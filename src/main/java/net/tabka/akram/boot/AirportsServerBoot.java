package net.tabka.akram.boot;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        Server server = new Server(Integer.parseInt(properties.getProperty("port","8080")));

        WebAppContext context = new WebAppContext();
        context.setResourceBase(properties.getProperty("webapp"));
        context.setContextPath("/");
        context.setServer(server);
        server.setHandler(context);

        server.start();
        server.dumpStdErr();
        server.join();
    }
}
