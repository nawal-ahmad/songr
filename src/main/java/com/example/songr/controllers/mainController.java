package com.example.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class mainController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/hello")
    public String getHello(@RequestParam(name = "name", defaultValue = "World", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable(value = "word") String word, Model model){
        String capital = word.toUpperCase();
        model.addAttribute("word", capital);
        return "capitalized";
    }
}

