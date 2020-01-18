package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.UserDAO;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.User;
import com.cko.sampleSpringProject.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RegistrationController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AuthorityService authorityService;


    @GetMapping("/registrationPage")
    public String showRegistrationPage() {

        return "registration";
    }

    @PostMapping("/registration")
    public String showRegistrationPage(@RequestParam String email, @RequestParam String password) {

        System.out.println(email + " " + password);
        Authority userAuthority = new Authority("ROLE_USER");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(userAuthority);



        User user = new User(email, password, authorities);
        userDAO.save(user);
        return "profilePage";
    }


}
