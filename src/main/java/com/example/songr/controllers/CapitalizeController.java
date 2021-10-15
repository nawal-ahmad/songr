package com.example.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {
    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable(value = "word") String word, Model model){
        String capital = word.toUpperCase();
        model.addAttribute("word", capital);
        return "capitalized";
    }
}
