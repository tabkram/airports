package net.tabka.akram.service;

import net.tabka.akram.model.Country;
import net.tabka.akram.repository.CountryRepo;

import static net.tabka.akram.utils.JsonUtil.json;
import static spark.Spark.get;

public class CountryService {

    public static void serve() {
        get("api/rest/countries/:country",  (request, response) -> {
            CountryRepo repo = new CountryRepo();
            String countryParam = request.params(":country");
            return repo.getCountriesByNameLike(request.params(":country"));
        }, json());
    }
}
