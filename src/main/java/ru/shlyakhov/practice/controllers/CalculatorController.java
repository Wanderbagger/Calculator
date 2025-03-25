package ru.shlyakhov.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shlyakhov.practice.models.Calculator;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class CalculatorController {


    @GetMapping("/index")
    public String index(@RequestParam(value = "expression", required = false) String expression,
                        Model model) {

        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam(value = "expression", required = false) String expression,
    Model model) {
        Calculator calculator = new Calculator();
        String result = calculator.recognizeExpression("2+3");
        model.addAttribute("messageResult", "Result: " + result);
        return "result";
    }

}