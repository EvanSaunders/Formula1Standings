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
public class RaceCalendar {
    ArrayList<Circuit> circuitList = new ArrayList<Circuit>();

    /**
     * Constructor that grabs info for a current year
     *
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public RaceCalendar() throws UnirestException, ParserConfigurationException, IOException {
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
    public RaceCalendar(String year) throws UnirestException, ParserConfigurationException, IOException {
        try {
            // Make the HTTP request and get the XML response
            URL url = new URL("http://ergast.com/api/f1/" + year + "/circuits");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Parse the XML response
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(connection.getInputStream());

            // Extract constructor information
            NodeList circuitNodeList = document.getElementsByTagName("Circuit");


            for (int i = 0; i < circuitNodeList.getLength(); i++) {

                Element circuitElement = (Element) circuitNodeList.item(i);

                String circuitName;
                String circuitId;


                try {
                    circuitName= circuitElement.getElementsByTagName("CircuitName").item(0).getTextContent();
                } catch (Exception e) {
                    circuitName = "Not Found";
                }

                try {
                    circuitId = circuitElement.getAttribute("circuitId");
                } catch (Exception e) {
                    circuitId = "Not Found";
                }



                Element locationElement = (Element) circuitElement.getElementsByTagName("Location").item(0);
                String locality = locationElement.getElementsByTagName("Locality").item(0).getTextContent();
                String country = locationElement.getElementsByTagName("Country").item(0).getTextContent();
                String lat = locationElement.getAttribute("lat");
                String lon = locationElement.getAttribute("long");


                Circuit currentCircuit = new Circuit(circuitName, locality, country, circuitId, lat, lon);
                circuitList.add(currentCircuit);
            }


            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * returns an arrayList containing all circuits in year
     * @return
     */
    public ArrayList getCircuits(){
        return circuitList;
    }

    /**
     * returns a specific circuit
     * @param circuitId
     * @return
     */
    public Circuit getCircuit(String circuitId){
        for( int i = 0; i< circuitList.size(); i++){
            if(circuitId.compareTo(circuitList.get(i).getId())==0){
                return circuitList.get(i);
            }
        }
        return null;
    }



    public String toString() {
        String string = "";
        for (int i = 0; i < circuitList.size(); i++) {
            string += circuitList.get(i) + "\n";

        }

        return string;
    }
}

