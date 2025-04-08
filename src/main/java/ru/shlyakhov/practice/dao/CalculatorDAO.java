package ru.shlyakhov.practice.dao;

import org.springframework.stereotype.Component;
import ru.shlyakhov.practice.calculator.Validator;
import ru.shlyakhov.practice.models.Calculation;
import ru.shlyakhov.practice.calculator.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CalculatorDAO {
    private static int calculationCounter = 0;
    private Calculation currentCalculation;
    private List<Calculation> calculationsArchive = new ArrayList<>();
    private Set<String> validatations = new HashSet<>();

    {
        currentCalculation = new Calculation(0, "0");
    }

    public Calculation index() {
        return currentCalculation;
    }

    public List<Calculation> archive() {
        return calculationsArchive;
    }
    public Set<String> validate() {
        return validatations;
    }

    /*
        public Calculation show(int id) {
            return calculations.get(id);
        }
    */
    public void save(Calculation calculation) {
        validatations = new Validator(calculation.getExpression()).validate();
        if(validatations.isEmpty()){
            calculation.setId(++calculationCounter);
            calculation.setResult(new Calculator().recognizeExpression(calculation.getExpression()));
            currentCalculation =  calculation;
            calculationsArchive.add(calculation);
            System.out.println("ARCHIVE:  " + calculationsArchive);
        } else {
            System.out.println("VALIDATIONS:  " + validatations);
        }
    }
}
