package ru.shlyakhov.practice.dao;

import org.springframework.stereotype.Component;
import ru.shlyakhov.practice.models.Calculation;
import ru.shlyakhov.practice.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDAO {
    private static int CALCULATION_COUNTER = 0;
    private List<Calculation> calculations;

    {
        calculations = new ArrayList<>();
        calculations.add(new Calculation(++CALCULATION_COUNTER, "2+2*2"));
        calculations.add(new Calculation(++CALCULATION_COUNTER, "2-2/2"));
        calculations.add(new Calculation(++CALCULATION_COUNTER, "2*2-2"));
        calculations.add(new Calculation(++CALCULATION_COUNTER, "2/2+2"));
    }

    public List<Calculation> index() {
        return calculations;
    }

    public Calculation show(int id) {
        return calculations.get(id);
    }

    public void save(Calculation calculation) {
        calculation.setId(++CALCULATION_COUNTER);
        calculation.setResult(new Calculator().recognizeExpression(calculation.getExpression()));
        calculations.add(calculation);
    }
}
