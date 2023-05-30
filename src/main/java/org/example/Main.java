package org.example;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) throws UnirestException, ParserConfigurationException, IOException {
        SpringApplication.run(Main.class, args);
    Grid grid = new Grid();
    System.out.println(grid);
   }

   @GetMapping("/")
   public String hello(){
        return "Hello World";
   }


}

