
import org.junit.jupiter.api.Test;
import ru.shlyakhov.practice.calculator.Calculator;
import ru.shlyakhov.practice.calculator.exceptions.InputDataException;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void convertData() {
        assertEquals(5.12, calculator.convertData("5.12"), "Проверка конвертации числа");
        assertEquals(0.15, calculator.convertData("0.154512321"), "Проверка конвертации длинного числа");
    }

    @Test
    public void convertInt() {
        assertEquals(515, calculator.convertInt("515"), "Проверка конвертиации целого числа");
        assertEquals(10000000, calculator.convertInt("10000000"), "Проверка конвертиации целого числа");
    }

    @Test
    public void convertDouble() {
        assertEquals(0.02, calculator.convertDouble("0212341324"), "Проверка конвертиации дробной части в округленное дробное");
    }

    @Test
    public void roundDouble() {
        assertEquals(5.12, calculator.roundDouble(5.124), "Проверка округления вниз");
        assertEquals(5.12, calculator.roundDouble(5.115), "Проверка округления вверх");
    }

    @Test
    public void isOperator() {
        assertTrue(calculator.isOperator('/'));
        assertTrue(calculator.isOperator('+'));
        assertTrue(calculator.isOperator('-'));
        assertTrue(calculator.isOperator('*'));
        assertFalse(calculator.isOperator(','));
    }

    @Test
    public void calculate() {
        assertEquals(8, calculator.calculate(4, 4, '+'));
        assertEquals(8, calculator.calculate(12, 4, '-'));
        assertEquals(8, calculator.calculate(4, 2, '*'));
        assertEquals(8, calculator.calculate(16, 2, '/'));
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.calculate(5, 0, '/'));
        String expectedMessage = "Division by zero is prohibited";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void recognizeExpression() {
        assertEquals("Проверка очередности действий", calculator.recognizeExpression("2+2*2"), "6.0");
        assertEquals("Проверка считывания унарного минуса", calculator.recognizeExpression("-2+2*-2"), "-6.0");
        assertEquals("Проверка считывания скобок", calculator.recognizeExpression("2*(2+2))"), "8.0");
        assertEquals("Проверка считывания двух пар скобок", calculator.recognizeExpression("2*(2+2+(4-8)-2))"), "-4.0");
    }

    @Test
    public void start() {
        Exception exception = assertThrows(InputDataException.class, () -> calculator.start(""));
        assertTrue(exception.getMessage().contains("The string is Empty"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("h1+1"));
        assertTrue(exception.getMessage().contains("The string contains letter"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("()"));
        assertTrue(exception.getMessage().contains("The string contains no digits"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("223"));
        assertTrue(exception.getMessage().contains("The string contains no operators"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("+2+2"));
        assertTrue(exception.getMessage().contains("The string starts with an invalid character"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("2+2+"));
        assertTrue(exception.getMessage().contains("The string ends with an invalid character"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("2+2++2"));
        assertTrue(exception.getMessage().contains("The string contains an incorrect sequence of characters"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("2.0.2+2"));
        assertTrue(exception.getMessage().contains("The string contains a number with two dots"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("(1+1))"));
        assertTrue(exception.getMessage().contains("The string contains incorrect brackets number"));

        exception = assertThrows(InputDataException.class, () -> calculator.start("1+(1+1+)"));
        assertTrue(exception.getMessage().contains("The string contains incorrect  brackets sequence"));
    }
}