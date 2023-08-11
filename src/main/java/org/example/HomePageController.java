package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage() {
        return "homePage.html";
    }

    @GetMapping("/displayByYear.html")
    public String displayByYear() {
        return "displayByYear"; // This should match the Thymeleaf template name
    }
}