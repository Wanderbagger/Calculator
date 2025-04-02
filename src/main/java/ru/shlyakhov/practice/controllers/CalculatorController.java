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


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("calculations", calculatorDAO.index());
        return "calculations/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("calculation", calculatorDAO.show(id));
        return "calculations/show";
    }

    @GetMapping("/input")
    public String inputExpression(@ModelAttribute("calculation") Calculation calculation) {
        return "calculations/input";
    }

    @PostMapping()
    public String create(@ModelAttribute("calculation") Calculation calculation) {
        calculatorDAO.save(calculation);
        System.out.println(calculation);
        return "redirect:/calculations";
    }
}