package ng.dat.ar.model;

import android.location.Location;

/**
 * Created by ntdat on 1/16/17.
 */

public class ARPoint {

    Location location;
    public String name;
    public Double lat,lng,alt;

    public ARPoint() {

    }

    public ARPoint(String name, Double alt, Double lat, Double lng) {
        this.name = name;
        location = new Location("ARPoint");
        location.setLatitude(lat);
        location.setLongitude(lng);
        location.setAltitude(alt);
    }

    public Location getLocation() {
        return location;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }


}

