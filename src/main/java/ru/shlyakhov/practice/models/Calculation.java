package ru.shlyakhov.practice.models;

import ru.shlyakhov.practice.calculator.Calculator;

public class Calculation {
    private int id;
    private String expression;
    private String result;

    public Calculation(int id, String expression) {
        this.id = id;
        this.expression = expression;
        this.result = new Calculator().recognizeExpression(expression);
    }

    public Calculation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", expression='" + expression + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
