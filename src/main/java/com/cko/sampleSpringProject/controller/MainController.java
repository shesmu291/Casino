package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage(){

        return "login";
    }

    @GetMapping("/")
    public String showMainPage(){
        return "mainPage";
    }

    @GetMapping("/test")
    public String showTestPage(){
        return "test";
    }

    @GetMapping("/productsPage")
    public String showProductsPage() { return "productsPage"; }

}
