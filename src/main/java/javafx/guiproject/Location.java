package javafx.guiproject;

public class Location {

    private String locationID;
    private String zipCode;
    private String city;
    private String stateAbb; // could be a drop-down list -- later development
    private String storeManager;

    public Location() {
    }

    public Location(String city, String storeManager, String zipCode, String stateAbb, String locationID) {
       this.city = city;
       this.storeManager = storeManager;
       this.zipCode = zipCode;
       this.stateAbb = stateAbb;
       this.locationID = locationID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) { // could have auto-incremented locationID, but again later development
        this.locationID = locationID;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbb() {
        return stateAbb;
    }

    public void setStateAbb(String stateAbb) {
        this.stateAbb = stateAbb;
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
    }

    public String toString() {
        return "Location ID: " + locationID +
                "\nCity: " + city +
                "\nState: " + stateAbb +
                "\nZip Code: " + zipCode +
                "\nStore Manager: " + storeManager + "\n";
    }

}
