package ru.shlyakhov.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shlyakhov.practice.models.Calculator;
import ru.shlyakhov.practice.models.CalculatorModel;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class CalculatorController {



    @GetMapping("/result")
    public String result(@RequestParam(value = "expression", required = false) String expression,
    Model model) {
        Calculator calculator = new Calculator();
        String result = calculator.recognizeExpression("2+3");
        model.addAttribute("messageResult", "Result: " + result);
        return "result";
    }
    @GetMapping("/index")
    public String inputExpression(Model model){
        model.addAttribute("calculator", new CalculatorModel());
        return "index";
    }
    @PostMapping()
    public String calculate(@ModelAttribute("calculator") CalculatorModel calculatorModel){

        return "redirect:/result";
    }

}