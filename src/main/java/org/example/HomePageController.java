package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomePageController {

    //Displays the homepage of the program. The starting point for the user.
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    //Displays the corresponding html page. Usually accessed by a button on the home page
    @GetMapping("/displayByYear.html")
    public String displayByYear() {
        return "displayByYear"; // This should match the Thymeleaf template name
    }

    @GetMapping("/displayByYearAndDriver.html")
    public String displayByYearAndDriver() {
        return "displayByYearAndDriver"; // This should match the Thymeleaf template name
    }

    @GetMapping("/displayCircuits.html")
    public String displayCircuits() {
        return "displayCircuits"; // This should match the Thymeleaf template name
    }

}