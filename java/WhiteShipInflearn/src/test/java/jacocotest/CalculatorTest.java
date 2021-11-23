package jacocotest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    private Calculator cal = new Calculator();

    @Test
    void addTest() {
        Assertions.assertEquals(3, cal.add(1, 2));
    }
}
