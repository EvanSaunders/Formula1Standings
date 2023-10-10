package org.example.Driver;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Service class responsible for generating HTML displays of F1 driver standings and circuits.
 * It interacts with data sources like the Grid and RaceCalendar to fetch driver and circuit information.
 */
@Service
public class DriverService {
    /**
     * prints that stats for drivers in a specific year
     * Mostly used for debugging
     * @param year
     * @return
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public String printGrid(String year) throws UnirestException, ParserConfigurationException, IOException {
        Grid grid = new Grid(year);
        return grid.toString();
    }

    /**
     * Generates HTML page containing stats for a specific year.
     * @param year
     * @return A string containing HTML code
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public String generateDisplayByYearHTML(String year) throws UnirestException, ParserConfigurationException, IOException {
        // Create a Grid object and fetch driver information
        Grid grid = new Grid(year);
        List<Driver> drivers = grid.getDrivers(); // Assuming you have a method to get the list of drivers

        // Create an HTML StringBuilder to build the HTML content
        StringBuilder htmlBuilder = new StringBuilder();

        // Load the HTML template
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>F1 Driver Stats</title>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            width: 100%; /* Make the table span the full width of the container */\n" +
                "            border-collapse: collapse; /* Remove spacing between table cells */\n" +
                "        }\n" +
                "        th, td {\n" +
                "            padding: 8px; /* Add padding to each cell for spacing */\n" +
                "            text-align: center; /* Center-align table data */\n" +
                "            color: white; \n" +
                "        }\n" +
                "        tr {\n" +
                "           border-bottom: 1px solid grey; \n"+
                "        }\n" +
                "        body {\n" +
                "            background-color: #1C1C1C; \n"+
                "        }\n" +
                "        h1 {\n" +
                "            color: #D90511; \n"+
                "            font-family: Arial, sans-serif; \n"+
                "            font-weight: 300px; \n"+
                "            letter-spacing: 8px; \n"+
                "            text-transform: uppercase; \n"+
                "            font-style:italic; \n"+
                "            font-size: 50px; \n"+
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>F1 Driver Stats for Year: [YEAR]</h1>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th>First</th>\n" +
                "        <th>Last</th>\n" +
                "        <th>Code</th>\n" +
                "        <th>Number</th>\n" +
                "        <th>ID</th>\n" +
                "        <th>Birthday</th>\n" +
                "        <th>Nationality</th>\n" +
                "        <th>Position</th>\n" +
                "        <th>Points</th>\n" +
                "        <th>Wins</th>\n" +
                "        <th>Constructor</th>\n" +
                "        <th>Constructor Nationality</th>\n" +
                "    </tr>\n" +
                "    [DRIVER_DATA]\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";

        // Replace placeholders with actual data
        template = template.replace("[YEAR]", year);

        StringBuilder driverRows = new StringBuilder();
        for (Driver driver : drivers) {
            String row = "<tr>" +
                    "<td>" + driver.getGivenName() + "</td>" +
                    "<td>" + driver.getFamilyName() + "</td>" +
                    "<td>" + driver.getCode() + "</td>" +
                    "<td>" + driver.getPermanentNumber() + "</td>" +
                    "<td>" + driver.getId() + "</td>" +
                    "<td>" + driver.getDateOfBirth() + "</td>" +
                    "<td>" + driver.getNationality() + "</td>" +
                    "<td>" + driver.getPosition() + "</td>" +
                    "<td>" + driver.getPoints() + "</td>" +
                    "<td>" + driver.getWins() + "</td>" +
                    "<td>" + driver.getConstructor() + "</td>" +
                    "<td>" + driver.getConstructorNationality() + "</td>" +
                    "</tr>";
            driverRows.append(row);
        }
        template = template.replace("[DRIVER_DATA]", driverRows.toString());

        // Set the final HTML content
        htmlBuilder.append(template);

        return htmlBuilder.toString();
    }
    /**
     * Generates HTML page containing a specific driver stats for a specific year
     * @param year
     * @param driverId
     * @return A string containing HTML code
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public String generateDisplayByYearAndDriverHTML(String year, String driverId) throws UnirestException, ParserConfigurationException, IOException {
        // Create a Grid object and fetch driver information
        Grid grid = new Grid(year);
        Driver driver = grid.getDriver(driverId);

        // Create an HTML StringBuilder to build the HTML content
        StringBuilder htmlBuilder = new StringBuilder();

        // Load the HTML template
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>F1 Driver Stats</title>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            width: 100%; /* Make the table span the full width of the container */\n" +
                "            border-collapse: collapse; /* Remove spacing between table cells */\n" +
                "        }\n" +
                "        th, td {\n" +
                "            padding: 8px; /* Add padding to each cell for spacing */\n" +
                "            text-align: center; /* Center-align table data */\n" +
                "            color: white; \n" +
                "        }\n" +
                "        tr {\n" +
                "           border-bottom: 1px solid grey; \n"+
                "        }\n" +
                "        body {\n" +
                "            background-color: #1C1C1C; \n"+
                "        }\n" +
                "        h1 {\n" +
                "            color: #D90511; \n"+
                "            font-family: Arial, sans-serif; \n"+
                "            font-weight: 300px; \n"+
                "            letter-spacing: 8px; \n"+
                "            text-transform: uppercase; \n"+
                "            font-style:italic; \n"+
                "            font-size: 50px; \n"+
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>F1 Driver Stats for [familyName]</h1>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th>First</th>\n" +
                "        <th>Last</th>\n" +
                "        <th>Code</th>\n" +
                "        <th>Number</th>\n" +
                "        <th>ID</th>\n" +
                "        <th>Birthday</th>\n" +
                "        <th>Nationality</th>\n" +
                "        <th>Position</th>\n" +
                "        <th>Points</th>\n" +
                "        <th>Wins</th>\n" +
                "        <th>Constructor</th>\n" +
                "        <th>Constructor Nationality</th>\n" +
                "    </tr>\n" +
                "    [DRIVER_DATA]\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";

        // Replace placeholders with actual data
        template = template.replace("[familyName]", driver.getGivenName() + " " +driver.getFamilyName()+" in year "+ year);

        StringBuilder driverRow = new StringBuilder();
            String row = "<tr>" +
                    "<td>" + driver.getGivenName() + "</td>" +
                    "<td>" + driver.getFamilyName() + "</td>" +
                    "<td>" + driver.getCode() + "</td>" +
                    "<td>" + driver.getPermanentNumber() + "</td>" +
                    "<td>" + driver.getId() + "</td>" +
                    "<td>" + driver.getDateOfBirth() + "</td>" +
                    "<td>" + driver.getNationality() + "</td>" +
                    "<td>" + driver.getPosition() + "</td>" +
                    "<td>" + driver.getPoints() + "</td>" +
                    "<td>" + driver.getWins() + "</td>" +
                    "<td>" + driver.getConstructor() + "</td>" +
                    "<td>" + driver.getConstructorNationality() + "</td>" +
                    "</tr>";
            driverRow.append(row);

        template = template.replace("[DRIVER_DATA]", driverRow.toString());

        // Set the final HTML content
        htmlBuilder.append(template);

        return htmlBuilder.toString();


        //Grid grid = new Grid(year);
       // Driver driver = grid.getDriver(driverId);

        //return driver.toString();
    }
    /**
     * Generates HTML page containing circuits information for a specific year
     * @param year
     * @return A string containing HTML code
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public String generateDisplayCircuitsHTML(String year) throws UnirestException, ParserConfigurationException, IOException {
        // Create a Grid object and fetch driver information
        RaceCalendar raceCalendar = new RaceCalendar(year);
        List<Circuit> circuits = raceCalendar.getCircuits(); // Assuming you have a method to get the list of drivers

        // Create an HTML StringBuilder to build the HTML content
        StringBuilder htmlBuilder = new StringBuilder();

        // Load the HTML template
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>F1 Calendar</title>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            width: 100%; /* Make the table span the full width of the container */\n" +
                "            border-collapse: collapse; /* Remove spacing between table cells */\n" +
                "        }\n" +
                "        th, td {\n" +
                "            padding: 8px; /* Add padding to each cell for spacing */\n" +
                "            text-align: center; /* Center-align table data */\n" +
                "            color: white; \n" +
                "        }\n" +
                "        tr {\n" +
                "           border-bottom: 1px solid grey; \n"+
                "        }\n" +
                "        body {\n" +
                "            background-color: #1C1C1C; \n"+
                "        }\n" +
                "        h1 {\n" +
                "            color: #D90511; \n"+
                "            font-family: Arial, sans-serif; \n"+
                "            font-weight: 300px; \n"+
                "            letter-spacing: 8px; \n"+
                "            text-transform: uppercase; \n"+
                "            font-style:italic; \n"+
                "            font-size: 50px; \n"+
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>F1 Circuits for Year: [YEAR]</h1>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th>Circuit Name</th>\n" +
                "        <th>Locality</th>\n" +
                "        <th>Flag</th>\n" +
                "        <th>Country</th>\n" +
                "        <th>Latitude</th>\n" +
                "        <th>Longitude</th>\n" +
                "    </tr>\n" +
                "    [CIRCUIT_DATA]\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";

        // Replace placeholders with actual data
        template = template.replace("[YEAR]", year);

        StringBuilder circuitRows = new StringBuilder();
        for (Circuit circuit : circuits) {
            String row = "<tr>" +
                    "<td>" + circuit.getName() + "</td>" +
                    "<td>" + circuit.getLocality() + "</td>" +
                    "<td><img src="+"https://flagsapi.com/"+ circuit.getCountryCode() +"/flat/64.png></td>"+
                    "<td>" + circuit.getCountry() + "</td>" +
                    "<td>" + circuit.getLat() + "</td>" +
                    "<td>" + circuit.getLon() + "</td>" +
                    "</tr>";
            circuitRows.append(row);
        }
        template = template.replace("[CIRCUIT_DATA]", circuitRows.toString());

        // Set the final HTML content
        htmlBuilder.append(template);

        return htmlBuilder.toString();
    }




}
