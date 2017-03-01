package net.tabka.akram.service;

import net.tabka.akram.model.Country;
import net.tabka.akram.model.Runway;
import net.tabka.akram.repository.AirportRepo;
import net.tabka.akram.repository.CountryRepo;
import net.tabka.akram.repository.RunwaysRepo;

import java.util.List;
import java.util.Optional;

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

        get("api/rest/countries/runways/types",  (request, response) -> {
            RunwaysRepo repo = new RunwaysRepo();
            return repo.getRunwayTypesByCounty("TN");
        }, json());

        get("api/rest/runways/identifications",  (request, response) -> {
            RunwaysRepo repo = new RunwaysRepo();
            String orderString = request.queryParams("order");
            String maxString =request.queryParams("max");
            Optional<Boolean> order = Optional.empty();
            Optional<Integer> max = Optional.empty();
            if(orderString != null){
                order = Optional.of(Boolean.parseBoolean(orderString));
            }
            if(maxString != null){
                max = Optional.of(Integer.parseInt(maxString));
            }

            return repo.getRunwaysIdentifications(order, max);
        }, json());

    }
}
