package net.tabka.akram.model;

import com.sugarcrm.ws.soap.Int;

import java.util.Optional;

public class Country {

    Integer id;
    String code;
    String name;
    String continent;
    String wikipedia_link;
    String keywords;

    Long AirportsNumber;

    public Country(Optional<String> id, Optional<String> code, Optional<String> name, Optional<String> continent, Optional<String> wikipedia_link, Optional<String> keywords) {
        id.ifPresent( x -> this.id = Integer.parseInt(x));
        code.ifPresent( x -> this.code = x);
        name.ifPresent( x -> this.name = x);
        continent.ifPresent( x -> this.continent = x);
        wikipedia_link.ifPresent( x -> this.wikipedia_link = x);
        keywords.ifPresent( x -> this.keywords = x);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public void setWikipedia_link(String wikipedia_link) {
        this.wikipedia_link = wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getAirportsNumber() {
        return AirportsNumber;
    }

    public void setAirportsNumber(Long airportsNumber) {
        AirportsNumber = airportsNumber;
    }
}
