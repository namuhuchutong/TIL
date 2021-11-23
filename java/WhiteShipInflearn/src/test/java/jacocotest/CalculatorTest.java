package jacocotest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    private final Calculator cal = new Calculator();

    @Test
    @DisplayName("계산기 덧셈 테스트")
    void addTest() {
        Assertions.assertEquals(3, cal.add(1, 2));
    }
}
