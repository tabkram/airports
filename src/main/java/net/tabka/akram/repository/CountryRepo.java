package net.tabka.akram.repository;

import net.tabka.akram.model.Country;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.MetaModelHelper;
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
public class CountryRepo {

    private static Table table;
    private static DataContext dataContext;

    public CountryRepo() {
        Repository airepo = new Repository("countries.csv");
        table = airepo.getTable();
        dataContext = airepo.getDataContext();
    }

    public static List<Country> getAllCountries() {
        Query query = dataContext.query().from(table).selectAll().toQuery();
        DataSet ds = dataContext.executeQuery(query);
        List<Country> countries = new ArrayList<>();
        while (ds.next()) {
            Row row = ds.getRow();
            countries.add(new Country(
                    Optional.of((String) row.getValue(table.getColumnByName("id"))),
                    Optional.of((String) row.getValue(table.getColumnByName("code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("name"))),
                    Optional.of((String) row.getValue(table.getColumnByName("continent"))),
                    Optional.of((String) row.getValue(table.getColumnByName("wikipedia_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("keywords")))
            ));
        }
        return countries;
    }

    public static Country getCountryByCountryCode(String countryCode) {
       return  getCountryBy("code", countryCode);
    }

    public static Country getCountryByCountryName(String countryName) {
        return  getCountryBy("name", countryName);
    }

    public static List<Country> getCountriesByNameLike(String countryName) {
        Column column = table.getColumnByName("name");
        Query query = dataContext.query().from(table).selectAll().where(column).like("%"+ countryName.substring(0, 1).toUpperCase() + countryName.substring(1) +"%").toQuery();
        DataSet ds = dataContext.executeQuery(query);
        Row row = null;
        List<Country> countries = new ArrayList<>();
        while (ds.next()) {
            row = ds.getRow();
            countries.add(new Country(
                    Optional.of((String) row.getValue(table.getColumnByName("id"))),
                    Optional.of((String) row.getValue(table.getColumnByName("code"))),
                    Optional.of((String) row.getValue(table.getColumnByName("name"))),
                    Optional.of((String) row.getValue(table.getColumnByName("continent"))),
                    Optional.of((String) row.getValue(table.getColumnByName("wikipedia_link"))),
                    Optional.of((String) row.getValue(table.getColumnByName("keywords")))
            ));
        }
        return countries;

    }

    public static Country getCountryBy(String ColumnName, String ColumnValue) {
        Column column = table.getColumnByName(ColumnName);
        Query query = dataContext.query().from(table).selectAll().where(column).eq(ColumnValue).toQuery();
        DataSet ds = dataContext.executeQuery(query);
        ds.next();
        Row row = ds.getRow();
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
