package net.tabka.akram.repository;

import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;

public class Repository {


    public void createMetaData(String fileName) {
        File file = new File(fileName);
        DataContext dataContext = DataContextFactory.createCsvDataContext(file, true);
    }


}
