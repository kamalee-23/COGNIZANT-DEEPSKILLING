import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NumberUtilityTest {

    @Test
    public void testAssertions() {

        NumberUtility utility = new NumberUtility();

        // Assert Equals
        assertEquals(49, utility.square(7));

        // Assert True
        assertTrue(25 > 10);

        // Assert False
        assertFalse(8 < 3);

        // Assert Null
        String city = null;
        assertNull(city);

        // Assert Not Null
        assertNotNull(utility.getCourseName());

    }

}