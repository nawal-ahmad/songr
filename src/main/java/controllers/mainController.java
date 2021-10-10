package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class mainController {
    @GetMapping("/hello")
    public String getHello(@RequestParam(name = "name", defaultValue = "World", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }
    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable(value = "word") String word, Model model){
        String capital = word.toUpperCase();
        model.addAttribute("word", capital);
        return "capitalized";
    }
}
