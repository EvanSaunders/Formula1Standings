package org.example.Driver;


import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping(path = "/driver")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {

        this.driverService = driverService;
    }

    @GetMapping(path = "{year}")
    public String printGrid(@PathVariable("year") String year) throws UnirestException, ParserConfigurationException, IOException {

        return driverService.printGrid(year);
    }

    @GetMapping(path = "{year}/{driverId}")
    public String printDriverInYear(@PathVariable("year") String year, @PathVariable("driverId") String driverId) throws UnirestException, ParserConfigurationException, IOException {

        return driverService.printDriverInYear(year, driverId);
    }

}




