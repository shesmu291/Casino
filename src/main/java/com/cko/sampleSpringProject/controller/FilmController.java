package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.service.SMSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    SMSCService smscService;

    @GetMapping("/all")
    public ModelAndView showAllFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allFilms");
        List<Film> filmsList = filmDAO.findAll();
        modelAndView.addObject("films", filmsList);

        return modelAndView;
    }

    @GetMapping("/newFilm")
    public String showNewFilmPage() {
        return "newFilm";
    }

    @PostMapping("/newFilm")
    public String addNewFilm(Film film) {
        filmDAO.save(film);
        return "allFilms";
    }
    @PostMapping("/newUser")//
    public String addNewUser(Film film) {
        filmDAO.save(film);
        return "allFilms";
    }
    @GetMapping("/editFilm")
    public ModelAndView showEditFilmPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }

    @PostMapping("/editFilm")
    public RedirectView editFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView("/film/all");
    }

    @GetMapping("/deleteFilm")
    public RedirectView deleteFilm(@RequestParam Long id) {
        filmDAO.deleteById(id);
        return new RedirectView("/film/all");
    }


}

