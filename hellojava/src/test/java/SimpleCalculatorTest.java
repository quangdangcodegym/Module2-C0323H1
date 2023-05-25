import com.codegym.uniit_test.SimpleCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleCalculatorTest {

    @Test
    @DisplayName("Testing add 0 + 0")
    public void testAdd0And0() {
        int first = 0;
        int second = 0;
        int expected = 2;

        int result = SimpleCalculator.add(first, second);
        assertEquals(expected, result);
    }
}
