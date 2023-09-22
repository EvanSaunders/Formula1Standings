package org.example.Driver;


import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Year;

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
    @GetMapping("/")
    public String index(){
        return "index";
    }
**/

@GetMapping(path = "/displayStandingsByYear")
@ResponseBody
public String printGrid(@RequestParam("year") String year) throws UnirestException, ParserConfigurationException, IOException {
    if(year==""){
        return driverService.generateDisplayByYearHTML("" + Year.now().getValue());
    }
    return driverService.generateDisplayByYearHTML(year);
}

    @GetMapping(path = "/displayStandingsByYearAndDriver")
    public String printDriverInYear(@RequestParam("year") String year, @RequestParam("driverId") String driverId) throws UnirestException, ParserConfigurationException, IOException {

        return driverService.generateDisplayByYearAndDriverHTML(year, driverId);
    }

}




