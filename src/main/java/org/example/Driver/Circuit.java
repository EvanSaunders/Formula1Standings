package org.example.Driver;

public class Circuit {
    String circuitName;
    String locality;
    String country;
    String circuitId;

    String lat;
    String lon;
    public Circuit(String circuitName_, String locality_, String country_, String circuitId_, String lat_, String lon_){
        circuitName = circuitName_;
        locality = locality_;
        country = country_;
        circuitId = circuitId_;
        lat = lat_;
        lon = lon_;

    }

    public Circuit(){

    }

    public String getId(){
        return circuitId;
    }


    public String getName(){
        return circuitName;
    }

    public String getLocality(){
        return locality;
    }
    public String getCountry(){
        return country;
    }
    public String getLat(){
        return lat;
    }
    public String getLon(){
        return lon;
    }




    public String toString(){
        return "Circuit Id: " + circuitId + "\n Circuit Name: " + circuitName + "\n Locality: " + locality + "\n Country: " +
                country + "\n Latitude: " + lat + "\n Longitude: "+ lon;
    }

}
