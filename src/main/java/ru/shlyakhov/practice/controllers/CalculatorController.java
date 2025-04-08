package ru.shlyakhov.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shlyakhov.practice.dao.CalculatorDAO;
import ru.shlyakhov.practice.models.Calculation;

@Controller
@RequestMapping("/calculations")
public class CalculatorController {
    CalculatorDAO calculatorDAO;

    @Autowired
    public CalculatorController(CalculatorDAO dao) {
        this.calculatorDAO = dao;
    }

    @GetMapping("/input")
    public String inputExpression(@ModelAttribute("calculation") Calculation calculation, Model model) {
        model.addAttribute("calculation", calculatorDAO.index());
        model.addAttribute("calculationsArchive", calculatorDAO.archive());
        model.addAttribute("validations", calculatorDAO.validate());
        return "calculations/input";
    }

    @PostMapping()
    public String create(@ModelAttribute("calculation") Calculation calculation) {
        calculatorDAO.save(calculation);
        return "redirect:/calculations/input";
    }

}