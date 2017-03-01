package net.tabka.akram.service;

import net.tabka.akram.model.Country;
import net.tabka.akram.repository.AirportRepo;
import net.tabka.akram.repository.CountryRepo;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static net.tabka.akram.utils.JsonUtil.json;
import static spark.Spark.get;

public final class AirportService {

    public static void serve() {
        get("api/rest/countries/:country/airports",  (request, response) -> {
            AirportRepo repo = new AirportRepo();
            CountryRepo countryRepo = new CountryRepo();
            String countryParam = request.params(":country");
            if(countryParam.length() == 2){
                Country country = countryRepo.getCountryByCountryCode(request.params(":country"));
                return repo.getAirportsByCountryCode(request.params(":country"));
            } else {
                Country country = countryRepo.getCountryByCountryName(request.params(":country"));
                return repo.getAirportsByCountryCode(country.getCode());
            }
        }, json());

        get("api/rest/airports",  (request, response) -> {
            AirportRepo repo = new AirportRepo();
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
            return repo.getAirportsByCountryCode(order, max);
        }, json());

    }
}

