package net.tabka.akram.model;

import java.util.Optional;

/**
 * Created by akram.tabka on 26/02/2017.
 */
public class Runway {
    Integer id;
    String airport_ref;
    String airport_ident;
    String length_ft;
    String width_ft;
    String surface;
    String lighted;
    String closed;
    String le_ident;
    String le_latitude_deg;
    String le_longitude_deg;
    String le_elevation_ft;
    String le_heading_degT;
    String le_displaced_threshold_ft;
    String he_ident;
    String he_latitude_deg;
    String he_longitude_deg;
    String he_elevation_ft;
    String he_heading_degT;
    String he_displaced_threshold_ft;

    public Runway(Optional<String> id, Optional<String> airport_ref, Optional<String> airport_ident, Optional<String> length_ft, Optional<String> width_ft, Optional<String> surface, Optional<String> lighted, Optional<String> closed, Optional<String> le_ident, Optional<String> le_latitude_deg, Optional<String> le_longitude_deg, Optional<String> le_elevation_ft, Optional<String> le_heading_degT, Optional<String> le_displaced_threshold_ft, Optional<String> he_ident, Optional<String> he_latitude_deg, Optional<String> he_longitude_deg, Optional<String> he_elevation_ft, Optional<String> he_heading_degT, Optional<String> he_displaced_threshold_ft) {
        id.ifPresent(x -> this.id = Integer.parseInt(x));
        airport_ref.ifPresent(x -> this.airport_ref = x);
        airport_ident.ifPresent(x -> this.airport_ident = x);
        length_ft.ifPresent(x -> this.length_ft = x);
        width_ft.ifPresent((x -> this.width_ft = x));
        surface.ifPresent(x -> this.surface = x);
        lighted.ifPresent(x -> this.lighted = x);
        closed.ifPresent(x -> this.closed = x);
        le_ident.ifPresent(x -> this.le_ident = x);
        le_latitude_deg.ifPresent(x -> this.le_latitude_deg = x);
        le_longitude_deg.ifPresent(x -> this.le_longitude_deg = x);
        le_elevation_ft.ifPresent(x -> this.le_elevation_ft = x);
        le_heading_degT.ifPresent(x -> this.le_heading_degT = x);
        le_displaced_threshold_ft.ifPresent(x -> this.le_displaced_threshold_ft = x);
        he_ident.ifPresent(x -> this.he_ident = x);
        he_latitude_deg.ifPresent(x -> this.he_latitude_deg = x);
        he_longitude_deg.ifPresent(x -> this.he_longitude_deg = x);
        he_elevation_ft.ifPresent(x -> this.he_elevation_ft = x);
        he_heading_degT.ifPresent(x -> this.he_heading_degT = x);
        he_displaced_threshold_ft.ifPresent(x -> this.he_displaced_threshold_ft = x);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirport_ref() {
        return airport_ref;
    }

    public void setAirport_ref(String airport_ref) {
        this.airport_ref = airport_ref;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public void setAirport_ident(String airport_ident) {
        this.airport_ident = airport_ident;
    }

    public String getLength_ft() {
        return length_ft;
    }

    public void setLength_ft(String length_ft) {
        this.length_ft = length_ft;
    }

    public String getWidth_ft() {
        return width_ft;
    }

    public void setWidth_ft(String width_ft) {
        this.width_ft = width_ft;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getLighted() {
        return lighted;
    }

    public void setLighted(String lighted) {
        this.lighted = lighted;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public String getLe_latitude_deg() {
        return le_latitude_deg;
    }

    public void setLe_latitude_deg(String le_latitude_deg) {
        this.le_latitude_deg = le_latitude_deg;
    }

    public String getLe_longitude_deg() {
        return le_longitude_deg;
    }

    public void setLe_longitude_deg(String le_longitude_deg) {
        this.le_longitude_deg = le_longitude_deg;
    }

    public String getLe_elevation_ft() {
        return le_elevation_ft;
    }

    public void setLe_elevation_ft(String le_elevation_ft) {
        this.le_elevation_ft = le_elevation_ft;
    }

    public String getLe_heading_degT() {
        return le_heading_degT;
    }

    public void setLe_heading_degT(String le_heading_degT) {
        this.le_heading_degT = le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return le_displaced_threshold_ft;
    }

    public void setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return he_ident;
    }

    public void setHe_ident(String he_ident) {
        this.he_ident = he_ident;
    }

    public String getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public void setHe_latitude_deg(String he_latitude_deg) {
        this.he_latitude_deg = he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public void setHe_longitude_deg(String he_longitude_deg) {
        this.he_longitude_deg = he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return he_elevation_ft;
    }

    public void setHe_elevation_ft(String he_elevation_ft) {
        this.he_elevation_ft = he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return he_heading_degT;
    }

    public void setHe_heading_degT(String he_heading_degT) {
        this.he_heading_degT = he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return he_displaced_threshold_ft;
    }

    public void setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }


}