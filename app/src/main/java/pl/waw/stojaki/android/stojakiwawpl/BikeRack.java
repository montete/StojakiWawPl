package pl.waw.stojaki.android.stojakiwawpl;

/**
 * Created by Mon on 2015-02-03.
 */
public class BikeRack {

    private String district;
    private String name;
    private String description;
    private String numberOf;

    public BikeRack() {
        this.district = "mockObj";
        this.name = "mockObj";
        this.description = "mockObj";;
        this.numberOf = "mockObj";;
        this.limit = false;
        this.status = status;
        this.facilities = new Facilities();
        this.lat = 0;
        this.lng = 0;
    }

    public boolean isLimit() {
        return limit;
    }

    public void setLimit(boolean limit) {
        this.limit = limit;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean limit;
    private boolean status;
    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    private Facilities facilities;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BikeRack bikeRack = (BikeRack) o;

        if (Double.compare(bikeRack.lat, lat) != 0) return false;
        if (Double.compare(bikeRack.lng, lng) != 0) return false;
        if (!name.equals(bikeRack.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    private double lat;
    private double lng;

    @Override
    public String toString() {
        return "BikeRack{" +
                "district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOf='" + numberOf + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(String numberOf) {
        this.numberOf = numberOf;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }



}
