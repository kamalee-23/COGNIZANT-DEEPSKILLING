import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testMultiply() {

        Calculator calculator = new Calculator();

        int result = calculator.multiply(6, 5);

        assertEquals(30, result);

    }

}