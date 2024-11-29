package com.rai.crimemanagementsystem.controller;

import com.rai.crimemanagementsystem.entity.Crime;
import com.rai.crimemanagementsystem.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crimes")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @GetMapping
    public String viewAllCrime(Model model){
        model.addAttribute("crimes", crimeService.getAllCrime());
        return "viewCrimes";
    }

    @GetMapping("/add")
    public String showAddCrimeForm(Model model){
        model.addAttribute("crime", new Crime());
        return "addCrime";
    }

    @PostMapping("/add")
    public String addCrime(@ModelAttribute Crime crime){
        crimeService.addCrime(crime);
        return "redirect:/crimes";
    }

    @GetMapping("/{id}")
    public String viewCrimeDetails(@PathVariable("id") Long id, Model model){
        Crime crime = crimeService.getCrimeById(id);
        if(crime == null){
            return "redirect:/crimes";
        }
        model.addAttribute("crime", crime);
        return "viewCrimeDetails";
    }
}
