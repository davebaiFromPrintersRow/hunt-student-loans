package loans;

import loans.v0.Calculator;
import org.joda.time.DateTime;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    private static final double ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS = 1.00;

    @Test
    public void testCalculator_WhenDailyInterestCalculated_ThenCorrectValueIsReturned() throws Exception {
        assertEquals(37, Calculator.getInterestAccruement(10000, 31, .0429), ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS);

        int daysInBetween = Calculator.getDaysSinceLastPayment(new DateTime(2017, 7, 3, 0, 0), new DateTime(2017, 8, 1, 0, 0));
        assertEquals(13.54, Calculator.getInterestAccruement(3250.18, daysInBetween, .05), ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS);
    }
}