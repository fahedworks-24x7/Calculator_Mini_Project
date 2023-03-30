import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void factorialTruePositive(){
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.fact(0), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.fact(6), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Finding factorial of a number for False Positive", 2, calculator.fact(5), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 720, calculator.fact(20), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Finding power for True Positive", 125, calculator.power(5, 3), DELTA);
        assertEquals("Finding power for True Positive", 10000, calculator.power(10, 4), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", -1000000, calculator.power(1, 100000), DELTA);
        assertNotEquals("Finding power for False Positive", 1234, calculator.power(6, 5), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.naturalLog(1), DELTA);
        assertEquals("Finding natural log for True Positive", 0, calculator.naturalLog(1), DELTA);
    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 2.7132, calculator.naturalLog(0.6739), DELTA);
        assertNotEquals("Finding natural log for False Positive", -100, calculator.naturalLog(2), DELTA);
    }

    @Test
    public void sqrootTruePositive(){
        assertEquals("Finding square root for True Positive", 190, calculator.sqroot(36100), DELTA);
        assertEquals("Finding square root for True Positive", 20, calculator.sqroot(400), DELTA);
    }

    @Test
    public void sqrootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 0.3, calculator.sqroot(0.25), DELTA);
        assertNotEquals("Finding square root for False Positive", -2, calculator.sqroot(9), DELTA);

    }


}
