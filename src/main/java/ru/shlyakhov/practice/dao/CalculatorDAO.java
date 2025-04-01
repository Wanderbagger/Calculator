package ru.shlyakhov.practice.dao;

import org.springframework.stereotype.Component;
import ru.shlyakhov.practice.models.Calculation;

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

    public Calculation show(int id){
        return calculations.get(id);
    }


}
