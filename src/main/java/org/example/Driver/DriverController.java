package org.example.Driver;


import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Year;

/**
 * Controller class for handling requests
 */

/**
 * Constructor for DriverController.
 * Creates a driverService for other functions to use
 */
@RestController
@RequestMapping(path = "/standings")
public class DriverController {
    @Autowired
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {

        this.driverService = driverService;
    }

    /**
     * Generates HTML page containing stats for a specific year.
     * @param year
     * @return A string containing HTML code
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    @GetMapping(path = "/displayStandingsByYear")
@ResponseBody
public String printGrid(@RequestParam("year") String year) throws UnirestException, ParserConfigurationException, IOException {
    if(year==""){
        return driverService.generateDisplayByYearHTML("" + Year.now().getValue());
    }
    return driverService.generateDisplayByYearHTML(year);
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
    @GetMapping(path = "/displayStandingsByYearAndDriver")
    public String printDriverInYear(@RequestParam("year") String year, @RequestParam("driverId") String driverId) throws UnirestException, ParserConfigurationException, IOException {

        return driverService.generateDisplayByYearAndDriverHTML(year, driverId);
    }

    /**
     * Generates HTML page containing circuits information for a specific year
     * @param year
     * @return A string containing HTML code
     * @throws UnirestException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    @GetMapping(path = "/displayCircuits")
    @ResponseBody
    public String printCircuits(@RequestParam("year") String year) throws UnirestException, ParserConfigurationException, IOException {
        if(year==""){
            return driverService.generateDisplayCircuitsHTML("" + Year.now().getValue());
        }
        return driverService.generateDisplayCircuitsHTML(year);
    }
}




