package org.example;


import com.mashape.unirest.http.exceptions.UnirestException;
import org.example.Driver.DriverController;
import org.example.Driver.Grid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws UnirestException, ParserConfigurationException, IOException {
        SpringApplication.run(Main.class, args);

   //Unrelated, prints to console
    Grid grid = new Grid();

    System.out.println(grid);
   }




}

