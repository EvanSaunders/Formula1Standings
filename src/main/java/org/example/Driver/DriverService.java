package org.example.Driver;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class DriverService {
    public String printGrid(String year) throws UnirestException, ParserConfigurationException, IOException {
        Grid grid = new Grid(year);
        return grid.toString();
    }
    public String printDriverInYear(String year, String driverId) throws UnirestException, ParserConfigurationException, IOException {
        Grid grid = new Grid(year);
        Driver driver = grid.getDriver(driverId);
        System.out.println(driver.toString()  +" aaaaaaaaaaa");
        return driver.toString();
    }



}
