package ru.shlyakhov.practice.models;

import javax.validation.constraints.NotEmpty;

public class Model {

    @NotEmpty
    private String expression = "2 + 2 * 2";
    private double result;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        Calculator calculator = new Calculator();
        calculator.recognizeExpression(getExpression());
        return result;
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }
}
