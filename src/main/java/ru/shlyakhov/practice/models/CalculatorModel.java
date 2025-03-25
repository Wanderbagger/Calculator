package ru.shlyakhov.practice.models;

import javax.validation.constraints.NotEmpty;

public class CalculatorModel {

    @NotEmpty
    private String expression = "2 + 2 * 2 - 1";
    private String result;

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        Calculator calculator = new Calculator();
        return calculator.recognizeExpression(getExpression());
    }
}
