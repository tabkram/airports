package net.tabka.akram.repository;

import au.com.bytecode.opencsv.CSVReader;
import net.tabka.akram.model.Airport;
import net.tabka.akram.model.Country;
import net.tabka.akram.model.Runway;
import net.tabka.akram.repository.Repository;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.BooleanComparator;

import java.io.File;
import java.util.*;

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

    public static List<Country> getAirportsByCountryCode(Optional<Boolean> isReversed, Optional<Integer> maxNumber) {
        Column countryName = table.getColumnByName("iso_country");
        Query query = dataContext.query().from(table).select(countryName).selectCount().groupBy(countryName).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        Row row = ds.getRow();
        List<Country> countries = new ArrayList<>();
        CountryRepo countryRepo = new CountryRepo();
        while (ds.next()) {
            row = ds.getRow();
            Country country = countryRepo.getCountryByCountryCode((String) row.getValue(table.getColumnByName("iso_country")));
            country.setAirportsNumber((Long) row.getValue(1));
            countries.add(country);
        }

        if(isReversed.isPresent()) {
            if (isReversed.get()) {
                countries.sort(Comparator.comparing((Country a) -> a.getAirportsNumber()).reversed());
            } else {
                countries.sort(Comparator.comparing((Country a) -> a.getAirportsNumber()));
            }
        }

        if (maxNumber.isPresent()){
            return countries.subList(0, maxNumber.get());
        } else {
            return countries;
        }
    }

}