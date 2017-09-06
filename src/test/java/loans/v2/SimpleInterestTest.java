package loans.v2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SimpleInterestTest {

    private static final double ONE_DOLLAR = 1.0;

    private static double principalBalance;
    private static double interestRatePerAnnum;
    private static int days;

    @Test
    public void testSimpleInterestCalculations() throws Exception {
        principalBalance = 3750.14;
        interestRatePerAnnum = 5.0;
        days = 31;
        double simpleInterest = SimpleInterest.calculateTotalInterest(principalBalance, interestRatePerAnnum, days);
        assertEquals(15.63, simpleInterest, ONE_DOLLAR);

        principalBalance = 1000;
        days = 365;
        simpleInterest = SimpleInterest.calculateTotalInterest(principalBalance, interestRatePerAnnum, days);
        assertEquals(50.0, simpleInterest, ONE_DOLLAR);
    }
}