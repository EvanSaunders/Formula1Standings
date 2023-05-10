package org.example;

import com.mashape.unirest.http.exceptions.UnirestException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws UnirestException, ParserConfigurationException, IOException {
    Grid grid = new Grid("2021");
    System.out.println(grid);
   }

}

