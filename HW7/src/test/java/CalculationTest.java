import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void add() {
        Calculation calculation = new Calculation(5,12);
        int actual = calculation.add();
        int expected = 17;
        assertEquals(expected,actual);

    }

    @Test
    public void sub() {
        Calculation calculation = new Calculation(5,12);
        int actual = calculation.sub();
        int expected = -7;
        assertEquals(expected,actual);
    }

    @Test
    public void mul() {
        Calculation calculation = new Calculation(3,5);
        int actual = calculation.mul();
        int expected = 15;
        assertEquals(expected,actual);
    }

    @Test
    public void div() {
        Calculation calculation = new Calculation(22,2);
        int actual = calculation.div();
        int expected = 11;
        assertEquals(expected,actual);
    }
}