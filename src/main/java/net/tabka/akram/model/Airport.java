package net.tabka.akram.model;


import java.util.Optional;

public class Airport {
    Integer id;
    String ident;
    String type;
    String name ;
    Float latitude_deg;
    Float longitude_deg;
    String elevation_ft;
    String continent;
    String  iso_country;
    String iso_region;
    String municipality;
    String scheduled_service;
    String  gps_code;
    String iata_code;
    String local_code;
    String home_link;
    String wikipedia_link;

    public Airport(Optional<String> id, Optional<String> ident, Optional<String> type, Optional<String> name, Optional<String> latitude_deg, Optional<String> longitude_deg, Optional<String> elevation_ft, Optional<String> continent, Optional<String> iso_country, Optional<String> iso_region, Optional<String> municipality, Optional<String> scheduled_service, Optional<String> gps_code, Optional<String> iata_code, Optional<String> local_code, Optional<String> home_link, Optional<String> wikipedia_link, Optional<String> keywords) {
        id.ifPresent( x -> this.id = Integer.parseInt(x));
        ident.ifPresent( x -> this.ident = x);
        type.ifPresent( x -> this.type = x);
        name.ifPresent( x -> this.name = x);
        latitude_deg.ifPresent( x -> this.latitude_deg = Float.parseFloat(x));
        longitude_deg.ifPresent( x -> this.longitude_deg = Float.parseFloat(x));
        elevation_ft.ifPresent( x -> this.elevation_ft = x);
        continent.ifPresent( x -> this.continent = x);
        iso_country.ifPresent( x -> this.iso_country = x);
        iso_region.ifPresent( x -> this.iso_region = x);
        municipality.ifPresent( x -> this.municipality = x);
        scheduled_service.ifPresent( x -> this.scheduled_service = x);
        gps_code.ifPresent( x -> this.gps_code = x);
        iata_code.ifPresent( x -> this.iata_code = x);
        local_code.ifPresent( x -> this.local_code = x);
        home_link.ifPresent( x -> this.home_link = x);
        wikipedia_link.ifPresent( x -> this.wikipedia_link = x);
        keywords.ifPresent( x -> this.keywords = x);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLatitude_deg() {
        return latitude_deg;
    }

    public void setLatitude_deg(Float latitude_deg) {
        this.latitude_deg = latitude_deg;
    }

    public Float getLongitude_deg() {
        return longitude_deg;
    }

    public void setLongitude_deg(Float longitude_deg) {
        this.longitude_deg = longitude_deg;
    }

    public String getElevation_ft() {
        return elevation_ft;
    }

    public void setElevation_ft(String elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }

    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduled_service() {
        return scheduled_service;
    }

    public void setScheduled_service(String scheduled_service) {
        this.scheduled_service = scheduled_service;
    }

    public String getGps_code() {
        return gps_code;
    }

    public void setGps_code(String gps_code) {
        this.gps_code = gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public void setLocal_code(String local_code) {
        this.local_code = local_code;
    }

    public String getHome_link() {
        return home_link;
    }

    public void setHome_link(String home_link) {
        this.home_link = home_link;
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

    String keywords;
}
