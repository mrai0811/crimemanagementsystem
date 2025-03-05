package com.rai.crimemanagementsystem.controller;

import com.rai.crimemanagementsystem.entity.Crime;
import com.rai.crimemanagementsystem.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/crimes")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @GetMapping
    public String viewAllCrime(Model model) {
        model.addAttribute("crimes", crimeService.getAllCrime());
        return "viewCrimes";
    }

    @GetMapping("/add")
    public String showAddCrimeForm(Model model) {
        model.addAttribute("crime", new Crime());
        return "addCrime";
    }

    @PostMapping("/add")
    public String addCrime(@ModelAttribute Crime crime) {
        crimeService.addCrime(crime);
        return "redirect:/crimes";
    }

    @GetMapping("/{id}")
    public String viewCrimeDetails(@PathVariable("id") Long id, Model model) {
        Crime crime = crimeService.getCrimeById(id);
        if (crime == null) {
            return "redirect:/crimes";
        }
        model.addAttribute("crime", crime);
        return "viewCrimeDetails";
    }

    @DeleteMapping("/{id}")
    public String deleteCrimeById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        boolean isDeleted = crimeService.deleteCrime(id);
        if (isDeleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Crime with ID " + id + " deleted successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Crime with ID " + id + " does not exist.");
        }
        return "redirect:/crimes";
    }

//    @DeleteMapping("/{id}")
//    public String deleteCrimeById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//        boolean isDeleted = crimeService.deleteCrime(id);
//        if (isDeleted) {
//            redirectAttributes.addFlashAttribute("successMessage", "Crime with ID " + id + " deleted successfully.");
//        } else {
//            redirectAttributes.addFlashAttribute("errorMessage", "Crime with ID " + id + " does not exist.");
//        }
//        return "redirect:/crimes";
//    }

//    let me add some comment to test it
}
