package org.example.Driver;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.time.Year;

/**
 * Class responsible for grabbing information from http://ergast.com/mrd/
 */
public class Grid {
    ArrayList<Driver> driverList = new ArrayList<Driver>();

    /**
     * Constructor that grabs info for a current year
     *
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public Grid() throws UnirestException, ParserConfigurationException, IOException {
        this("" + Year.now().getValue());
    }

    /**
     * Constructor that grabs info for specific year
     *
     * @param year gets the grid for specified year
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public Grid(String year) throws UnirestException, ParserConfigurationException, IOException {
        try {
            // Make the HTTP request and get the XML response
            URL url = new URL("http://ergast.com/api/f1/" + year + "/driverstandings");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Parse the XML response
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(connection.getInputStream());

            // Extract constructor information
            NodeList driverStandingsList = document.getElementsByTagName("DriverStanding");


            for (int i = 0; i < driverStandingsList.getLength(); i++) {
                Element driverStanding = (Element) driverStandingsList.item(i);
                Element driver = (Element) driverStanding.getElementsByTagName("Driver").item(0);

                String driverId;
                String code;
                String permanentNumber;
                String givenName;
                String familyName;
                String dateOfBirth;
                String nationality;
                String position;
                String points;
                String wins;

                try {
                    driverId = driver.getAttribute("driverId");
                } catch (Exception e) {
                    driverId = "Not Found";
                }

                try {
                    code = driver.getAttribute("code");
                } catch (Exception e) {
                    code = "Not Found";
                }

                try {
                    permanentNumber = driver.getElementsByTagName("PermanentNumber").item(0).getTextContent();
                } catch (Exception e) {
                    permanentNumber = "Not Found";
                }

                try {
                    givenName = driver.getElementsByTagName("GivenName").item(0).getTextContent();
                } catch (Exception e) {
                    givenName = "Not Found";
                }

                try {
                    familyName = driver.getElementsByTagName("FamilyName").item(0).getTextContent();
                } catch (Exception e) {
                    familyName = "Not Found";
                }

                try {
                    dateOfBirth = driver.getElementsByTagName("DateOfBirth").item(0).getTextContent();
                } catch (Exception e) {
                    dateOfBirth = "Not Found";
                }

                try {
                    nationality = driver.getElementsByTagName("Nationality").item(0).getTextContent();
                } catch (Exception e) {
                    nationality = "Not Found";
                }

                try {
                    position = driverStanding.getAttribute("position");
                } catch (Exception e) {
                    position = "Not Found";
                }

                try {
                    points = driverStanding.getAttribute("points");
                } catch (Exception e) {
                    points = "Not Found";
                }

                try {
                    wins = driverStanding.getAttribute("wins");
                } catch (Exception e) {
                    wins = "Not Found";
                }


                Element constructor = (Element) driverStanding.getElementsByTagName("Constructor").item(0);

                String constructorName = constructor.getElementsByTagName("Name").item(0).getTextContent();
                String constructorNationality = constructor.getElementsByTagName("Nationality").item(0).getTextContent();

                Driver currentDriver = new Driver(driverId, code, permanentNumber, givenName, familyName, dateOfBirth, nationality,
                        position, points, wins, constructorName, constructorNationality);
                driverList.add(currentDriver);
            }


            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * returns and ArrayList containing all drivers in year
     * @return driverList
     */
    public ArrayList getDrivers(){
        return driverList;
    }

    /**
     * gets a specific driver
     * @param driverId what driver we are looking for
     * @return
     */
    public Driver getDriver(String driverId){
        for( int i = 0; i< driverList.size(); i++){
            if(driverId.compareTo(driverList.get(i).getId())==0){
                return driverList.get(i);
            }
        }
        return null;
    }



    public String toString() {
        String string = "";
        for (int i = 0; i < driverList.size(); i++) {
            string += driverList.get(i) + "\n";

        }

        return string;
    }
}

