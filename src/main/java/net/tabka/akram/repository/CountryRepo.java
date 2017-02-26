package net.tabka.akram.repository;

import net.tabka.akram.model.Country;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;

import java.util.Optional;

/**
 * Created by akram.tabka on 26/02/2017.
 */
public class CountryRepo {

    private static Table table;
    private static DataContext dataContext;

    public CountryRepo() {
        Repository airepo = new Repository("countries.csv");
        table = airepo.getTable();
        dataContext = airepo.getDataContext();
    }

    public static Country getCountryByCountryCode(String countryCode) {
       return  getCountryBy("code", countryCode);
    }

    public static Country getCountryByCountryName(String countryName) {
        return  getCountryBy("name", countryName);
    }

    public static Country getCountryBy(String ColumnName, String ColumnValue) {
        Column column = table.getColumnByName(ColumnName);
        Query query = dataContext.query().from(table).selectAll().where(column).eq(ColumnValue).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        Row row = null;
        while (ds.next()) {row = ds.getRow();}
        return new Country(
                Optional.of((String) row.getValue(table.getColumnByName("id"))),
                Optional.of((String) row.getValue(table.getColumnByName("code"))),
                Optional.of((String) row.getValue(table.getColumnByName("name"))),
                Optional.of((String) row.getValue(table.getColumnByName("continent"))),
                Optional.of((String) row.getValue(table.getColumnByName("wikipedia_link"))),
                Optional.of((String) row.getValue(table.getColumnByName("keywords")))
        );
    }
}
