package loans;

import org.joda.time.DateTime;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoanDetailsTest {

    private static final double ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS = 1.00;

    @Test
    public void testLoanObject_WhenLoanIsQueried_ThenCorrectLoanDetailsAreReturned() throws Exception {
        LoanDetails per24A = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4000)
                .remainingPrincipalBalance(3250.18)
                .interestRate(.05)
                .lastPaymentDate(new DateTime(2017, 7, 03, 0, 0))
                .build();
        LoanDetails per24B = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4500).build();
        LoanDetails per24C = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4500).build();
        LoanDetails per24D = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 2250).build();

        assertEquals(4000, per24A.getOriginalDisbursementAmount(), ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS);
        assertEquals(13.54, per24A.getInterestPaymentOnUpcomingBill(new DateTime(2017, 8, 01, 0, 0)), ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS);
    }

    @Test
    public void testLoanCalculations_WhenLoanPaymentIsMade_ThenFutureIsPredictedCorrectly() throws Exception {

    }
}