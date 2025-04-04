package ru.shlyakhov.practice.dao;

import org.springframework.stereotype.Component;
import ru.shlyakhov.practice.models.Calculation;
import ru.shlyakhov.practice.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDAO {
    private static int calculationCounter = 0;
    private List<Calculation> calculations;
    private List<Calculation> calculationsArchive = new ArrayList<>();

    {
        calculations = new ArrayList<>();
        calculations.add(new Calculation(0, "0"));

    }

    public List<Calculation> index() {
        return calculations;
    }

    public List<Calculation> archive() {
        return calculationsArchive;
    }

    /*
        public Calculation show(int id) {
            return calculations.get(id);
        }
    */
    public void save(Calculation calculation) {
        calculation.setId(++calculationCounter);
        calculation.setResult(new Calculator().recognizeExpression(calculation.getExpression()));
        calculations.set(0, calculation);
        calculationsArchive.add(calculation);
        System.out.println("ARCHIVE:  " + calculationsArchive);
    }
}
