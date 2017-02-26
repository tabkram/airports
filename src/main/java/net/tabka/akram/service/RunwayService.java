package net.tabka.akram.service;

import net.tabka.akram.model.Country;
import net.tabka.akram.model.Runway;
import net.tabka.akram.repository.AirportRepo;
import net.tabka.akram.repository.CountryRepo;
import net.tabka.akram.repository.RunwaysRepo;

import java.util.List;

import static net.tabka.akram.utils.JsonUtil.json;
import static spark.Spark.get;

public class RunwayService {
    public static void serve() {
        get("api/rest/airports/:airport/runways",  (request, response) -> {
            AirportRepo repo = new AirportRepo();
            CountryRepo countryRepo = new CountryRepo();
            String runwayParam = request.params(":airport");
            RunwaysRepo runwaysRepo = new RunwaysRepo();
            return runwaysRepo.getRunwaysByAirport(runwayParam);
        }, json());
    }
}
