package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/displayByYear.html")
    public String displayByYear() {
        return "displayByYear"; // This should match the Thymeleaf template name
    }

    @GetMapping("/displayByYearAndDriver.html")
    public String displayByYearAndDriver() {
        return "displayByYearAndDriver"; // This should match the Thymeleaf template name
    }
}