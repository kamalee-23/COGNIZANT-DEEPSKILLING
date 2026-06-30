import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    @Before
    public void setUp() {

        calculator = new DiscountCalculator();

        System.out.println("Setup Completed");

    }

    @After
    public void tearDown() {

        calculator = null;

        System.out.println("Resources Released");

    }

    @Test
    public void testCalculateDiscount() {

        // Arrange
        double amount = 5000;
        double discount = 20;

        // Act
        double finalAmount = calculator.calculateDiscount(amount, discount);

        // Assert
        assertEquals(4000.0, finalAmount, 0.01);

    }

}