package net.tabka.akram.repository;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

import java.io.File;

public final class Repository {
    private static Table table ;
    private static DataContext dataContext;

    public Repository(String fileName) {
        File file = new File(CSVReader.class.getClassLoader().getResource(fileName).getFile());
        dataContext = DataContextFactory.createCsvDataContext(file);
        final Schema schema = dataContext.getDefaultSchema();
        table = schema.getTableByName(fileName);
    }

    public static Table getTable() {
        return table;
    }

    public static void setTable(Table table) {
        Repository.table = table;
    }

    public static DataContext getDataContext() {
        return dataContext;
    }

    public static void setDataContext(DataContext dataContext) {
        Repository.dataContext = dataContext;
    }
}
