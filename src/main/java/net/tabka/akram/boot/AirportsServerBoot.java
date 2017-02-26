package net.tabka.akram.boot;

import net.tabka.akram.model.Country;
import net.tabka.akram.repository.AirportRepo;
import net.tabka.akram.repository.CountryRepo;
import net.tabka.akram.service.AirportService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.util.Properties;

import static net.tabka.akram.utils.JsonUtil.json;
import static spark.Spark.*;

public class AirportsServerBoot {

    static Properties properties = new Properties();

    private static void initConfigfile() {
        try {
            properties.load(AirportsServerBoot.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main( String[] args ) throws Exception
    {
        initConfigfile();
        port(Integer.parseInt(properties.getProperty("port","8080")));
        externalStaticFileLocation(properties.getProperty("webapp"));
        AirportService.serve();
    }
}
