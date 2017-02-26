package net.tabka.akram.repository;

import au.com.bytecode.opencsv.CSVReader;
import net.tabka.akram.model.Airport;
import net.tabka.akram.model.Runway;
import net.tabka.akram.repository.Repository;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AirportRepo {

    private static Table table;
    private static DataContext dataContext;

    public AirportRepo() {
        Repository airepo = new Repository("airports.csv");
        table = airepo.getTable();
        dataContext = airepo.getDataContext();
    }

    public static List<Airport> getAirportsByCountryCode(String countryCode) {
        Column countryName = table.getColumnByName("iso_country");
        Query query = dataContext.query().from(table).selectAll().where(countryName).eq(countryCode).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        List<Airport> airportList = new ArrayList<>();
        while (ds.next()) {
            Row row = ds.getRow();
            airportList.add(new Airport(
                    Optional.of((String)row.getValue(table.getColumnByName("id"))),
                    Optional.of((String) row.getValue(table.getColumnByName("ident"))),
                    Optional.of((String) row.getValue(table.getColumnByName("type"))),
                    Optional.of((String) row.getValue(table.getColumnByName("name"))),
                    Optional.of((String) row.getValue(table.getColumnByName("latitude_deg"))),
                    Optional.of((String) row.getValue(table.getColumnByName("longitude_deg"))),
                    Optional.of((String) row.getValue(table.getColumnByName("elevation_ft"))),
                    Optional.of((String) row.getValue(table.getColumnByName("continent"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iso_country"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iso_region"))),
                    Optional.of((String) row.getValue(table.getColumnByName("municipality"))),
                    Optional.of((String) row.getValue(table.getColumnByName("scheduled_service"))),
                    Optional.of((String) row.getValue(table.getColumnByName("gps_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iata_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("local_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("home_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("wikipedia_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("keywords"))),
                    Optional.empty()
            ));
        }
        return airportList;
    }

    @Deprecated
    public static List<Airport> getAirportsAndRunwaysByCountryCode(String countryCode) {
        Column countryName = table.getColumnByName("iso_country");
        Query query = dataContext.query().from(table).selectAll().where(countryName).eq(countryCode).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        List<Airport> airportList = new ArrayList<>();
        RunwaysRepo runwaysRepo = new RunwaysRepo();
        while (ds.next()) {
            Row row = ds.getRow();
            List<Runway> runways = runwaysRepo.getRunwaysByAirport((String) row.getValue(table.getColumnByName("ident")));
            airportList.add(new Airport(
                    Optional.of((String)row.getValue(table.getColumnByName("id"))),
                    Optional.of((String) row.getValue(table.getColumnByName("ident"))),
                    Optional.of((String) row.getValue(table.getColumnByName("type"))),
                    Optional.of((String) row.getValue(table.getColumnByName("name"))),
                    Optional.of((String) row.getValue(table.getColumnByName("latitude_deg"))),
                    Optional.of((String) row.getValue(table.getColumnByName("longitude_deg"))),
                    Optional.of((String) row.getValue(table.getColumnByName("elevation_ft"))),
                    Optional.of((String) row.getValue(table.getColumnByName("continent"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iso_country"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iso_region"))),
                    Optional.of((String) row.getValue(table.getColumnByName("municipality"))),
                    Optional.of((String) row.getValue(table.getColumnByName("scheduled_service"))),
                    Optional.of((String) row.getValue(table.getColumnByName("gps_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("iata_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("local_code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("home_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("wikipedia_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("keywords"))),
                    Optional.of(runways)
            ));

        }
        return airportList;
    }
}