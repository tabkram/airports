package net.tabka.akram.repository;

import au.com.bytecode.opencsv.CSVReader;
import net.tabka.akram.repository.Repository;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

import java.io.File;

public class AirportRepo {

    private static Table table;
    private static DataContext dataContext;

    public AirportRepo() {
        Repository airepo = new Repository("airports.csv");
        table = airepo.getTable();
        dataContext = airepo.getDataContext();
    }

    public static void getAirportsByCountryCode() {
        Column airportNameColumn = table.getColumnByName("name");
        Column countryName = table.getColumnByName("iso_country");
//        Query query = dataContext.query().from(table).select(airportNameColumn).selectCount().groupBy(airportNameColumn).toQuery();
        Query query = dataContext.query().from(table).select(airportNameColumn).where(countryName).eq("US").toQuery();
        System.out.println(query.toString());
        DataSet ds = dataContext.executeQuery(query);
        while (ds.next()) {
            Row row = ds.getRow();
            String airportName = (String) row.getValue(airportNameColumn);
            System.out.println(airportName);
        }
    }


}