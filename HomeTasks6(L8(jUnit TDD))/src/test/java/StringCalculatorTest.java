import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void addEmptyStringTest() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add(" ");
        assertEquals(0, result);
    }

    @Test
    public void addOneStringTest() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("1");
        assertEquals(1, result);
    }

    @Test
    public void addTwoStringTest() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("2");
        assertEquals(2, result);
    }

    @Test
    public void addStringWithCommaTest() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("5,8");
        assertEquals(13, result);
    }


    @Test
    public void addStringWithUnknownAmountOfNumbers() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("1,2,3,4,6");
        assertEquals(16, result);
    }

    @Test
    public void addStringWithNewLines() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("1\n5,4");
        assertEquals(10, result);
    }

    @Test
    public void addStringWithMultipleDelimiters() throws Exception {
        StringCalculator str = new StringCalculator();
        int result = str.Add("//;\n4;3");
        int result2 = str.Add("//!\n1!2!3!4!5");
        assertEquals(7, result);
        assertEquals(15, result2);
    }

    @Test
    public void addStringException() {
        StringCalculator str = new StringCalculator();
        int result = 0;
        try {
            result = str.Add("-1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addStringExceptionMultiNum() {
        StringCalculator str = new StringCalculator();
        int result = 0;
        try {
            result = str.Add("//:\n-2:-1:-5:-2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}