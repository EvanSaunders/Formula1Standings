package org.example;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.time.Year;

public class Grid {
    ArrayList<Driver> driverList = new ArrayList<Driver>();
    public Grid() throws UnirestException, ParserConfigurationException, IOException {
        int year = Year.now().getValue();


        String apiUrl = "http://ergast.com/api/f1/"+ year+ "/drivers.json";

        // Open a connection to the API endpoint
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read the API response into a String
        String response = readResponse(conn);

        // Parse the JSON response and extract the driver names
        ArrayList<String> driverIds = parseDriverId(response);

        String[] infoOptions = {"driverId", "code", "permanentNumber", "givenName", "familyName", "dateOfBirth","nationality"};
        // Print the driver names to the console
        for (int i = 0; i< driverIds.size(); i++) {
            String[] driverAllInfo = new String[7];
            for(int x = 0; x<infoOptions.length;x++){
               // System.out.println(driverName);
                String currentDriverInfo = parseDriverInfo(response, driverIds.get(i),infoOptions[x]);
                driverAllInfo[x] = currentDriverInfo;
            }
            Driver currentDriver = new Driver(driverAllInfo);
           driverList.add(currentDriver);
        }
    }

    // TODO not every year has code, permanentNumber
    public Grid( String year) throws UnirestException, ParserConfigurationException, IOException {



        String apiUrl = "http://ergast.com/api/f1/"+ year+ "/drivers.json";

        // Open a connection to the API endpoint
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read the API response into a String
        String response = readResponse(conn);

        // Parse the JSON response and extract the driver names
        ArrayList<String> driverIds = parseDriverId(response);

        String[] infoOptions = {"driverId", "code", "permanentNumber", "givenName", "familyName", "dateOfBirth","nationality"};
        // Print the driver names to the console
        for (int i = 0; i< driverIds.size(); i++) {
            String[] driverAllInfo = new String[7];
            for(int x = 0; x<infoOptions.length;x++){
                // System.out.println(driverName);
                String currentDriverInfo = parseDriverInfo(response, driverIds.get(i),infoOptions[x]);
                driverAllInfo[x] = currentDriverInfo;
            }
            Driver currentDriver = new Driver(driverAllInfo);
            driverList.add(currentDriver);
        }
    }

    //gets what the api responds with
    private static String readResponse(HttpURLConnection conn) throws IOException {
        StringBuilder response = new StringBuilder();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line =  bufferedReader.readLine()) != null) {
                response.append(line);
            }
        } else {
            throw new RuntimeException("HTTP response code: " + responseCode);
        }
        return response.toString();
    }

    private static ArrayList<String> parseDriverId(String response) {
        ArrayList<String> driverNames = new ArrayList<>();

        JSONObject rootObject = new JSONObject(response);
        JSONObject mrDataObject = rootObject.getJSONObject("MRData");
        JSONObject driverTableObject = mrDataObject.getJSONObject("DriverTable");
        JSONArray driverArray = driverTableObject.getJSONArray("Drivers");

        for (int i = 0; i < driverArray.length(); i++) {
            JSONObject driverObject = driverArray.getJSONObject(i);
            String driverName = driverObject.getString("driverId");
            driverNames.add(driverName);
        }

        return driverNames;
    }

    private static String parseDriverInfo(String response, String driverId, String info) {
        //ArrayList<String> driverNames = new ArrayList<>();

        JSONObject rootObject = new JSONObject(response);
        JSONObject mrDataObject = rootObject.getJSONObject("MRData");
        JSONObject driverTableObject = mrDataObject.getJSONObject("DriverTable");
        JSONArray driverArray = driverTableObject.getJSONArray("Drivers");

        for (int i = 0; i < driverArray.length(); i++) {
            JSONObject driverObject = driverArray.getJSONObject(i);
            String name = driverObject.getString("driverId");
            if (name.equalsIgnoreCase(driverId)) {
                return driverObject.getString(info);
            }
        }
        return "fail";
    }
    public String toString(){
        String string = "";
        for(int i = 0; i< driverList.size();i++){
            string += driverList.get(i)+"\n";
        }

        return string;
    }

    }

