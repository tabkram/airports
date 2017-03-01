package net.tabka.akram.repository;

import net.tabka.akram.model.Airport;
import net.tabka.akram.model.Country;
import net.tabka.akram.model.Identification;
import net.tabka.akram.model.Runway;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.MetaModelHelper;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

import java.util.*;

/**
 * Created by akram.tabka on 26/02/2017.
 */
public class RunwaysRepo {
    private static Table table;
    private static DataContext dataContext;

    public RunwaysRepo() {
        Repository runwayRepo = new Repository("runways.csv");
        table = runwayRepo.getTable();
        dataContext = runwayRepo.getDataContext();
    }

    public DataSet getRunwaysDataSet(){
        Query query = dataContext.query().from(table).selectAll().toQuery();
        return dataContext.executeQuery(query);
    }

    public List<Runway> getRunwaysByAirport(String airport_ident){
        Column column = table.getColumnByName("airport_ident");
        Query query = dataContext.query().from(table).selectAll().where(column).eq(airport_ident).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        List<Runway> runwayList = new ArrayList<>();
        while (ds.next()) {
            Row row = ds.getRow();
            runwayList.add(new Runway(
                    Optional.of((String)row.getValue(table.getColumnByName("id"))),
                    Optional.of((String)row.getValue(table.getColumnByName("airport_ref"))),
                    Optional.of((String)row.getValue(table.getColumnByName("airport_ident"))),
                    Optional.of((String)row.getValue(table.getColumnByName("length_ft"))),
                    Optional.of((String)row.getValue(table.getColumnByName("width_ft"))),
                    Optional.of((String)row.getValue(table.getColumnByName("surface"))),
                    Optional.of((String)row.getValue(table.getColumnByName("lighted"))),
                    Optional.of((String)row.getValue(table.getColumnByName("closed"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_ident"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_latitude_deg"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_longitude_deg"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_elevation_ft"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_heading_degT"))),
                    Optional.of((String)row.getValue(table.getColumnByName("le_displaced_threshold_ft"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_ident"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_latitude_deg"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_longitude_deg"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_elevation_ft"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_heading_degT"))),
                    Optional.of((String)row.getValue(table.getColumnByName("he_displaced_threshold_ft")))
            ));
        }
        return runwayList;
    }


    public static Set<String> getRunwayTypesByCounty(String country) {
        AirportRepo airepo = new AirportRepo();
        List<Airport> airports = airepo.getAirportsAndRunwaysByCountryCode(country);
        Set<String> runwayTypes = new HashSet<>();
        airports.forEach(airport -> {
            airport.getRunways().forEach(runway -> {
                runwayTypes.add(runway.getSurface());
            });
        });
        return runwayTypes;
    }

    public List<Identification> getRunwaysIdentifications(Optional<Boolean> isReversed, Optional<Integer> maxNumber){
        Column indentCol = table.getColumnByName("le_ident");
        Query query = dataContext.query().from(table).select(indentCol).selectCount().groupBy(indentCol).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        List<Identification> indentList = new ArrayList<>();
        while (ds.next()) {
            Row row = ds.getRow();
            indentList.add(new Identification((String) row.getValue(0),(Long) row.getValue(1)));
        }

        if(isReversed.isPresent()) {
            if (isReversed.get()) {
                indentList.sort(Comparator.comparing((Identification a) -> a.getNumber()).reversed());
            } else {
                indentList.sort(Comparator.comparing((Identification a) -> a.getNumber()));
            }
        }

        if (maxNumber.isPresent()){
            return indentList.subList(0, maxNumber.get());
        } else {
            return indentList;
        }
    }
}
