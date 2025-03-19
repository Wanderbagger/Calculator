package ru.shlyakhov.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class CalculatorController {


    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        String expression = request.getParameter("expression");
        System.out.println(expression);
        return "index";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

}