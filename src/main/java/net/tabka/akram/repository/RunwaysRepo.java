package net.tabka.akram.repository;

import net.tabka.akram.model.Airport;
import net.tabka.akram.model.Country;
import net.tabka.akram.model.Runway;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

}
