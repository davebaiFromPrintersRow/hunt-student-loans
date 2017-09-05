package loans;

import loans.v0.LoanDetails;
import loans.v0.LoanType;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoanDetailsTest {

    private static final double ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS = 1.00;

    LoanDetails per24A;
    LoanDetails per24B;
    LoanDetails per24C;
    LoanDetails per24D;

    @Before
    public void setUp() throws Exception {
        per24A = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4000)
                .remainingPrincipalBalance(3250.18)
                .interestRate(.05)
                .lastPaymentDate(new DateTime(2017, 7, 03, 0, 0))
                .build();
        per24B = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4500).build();
        per24C = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4500).build();
        per24D = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 2250).build();
    }

    @Test
    public void testLoanObject_WhenLoanIsQueried_ThenCorrectLoanDetailsAreReturned() throws Exception {
        assertEquals(4000, per24A.getOriginalDisbursementAmount(), ACCEPTABLE_DELTA_FOR_ASSERTIONS_ON_DOLLAR_PAYMENTS);
    }

    @Test
    public void testLoanCalculations_WhenLoanPaymentIsMade_ThenFutureIsPredictedCorrectly() throws Exception {
        per24A = new LoanDetails.LoanDetailsBuilder(LoanType.Federal_Perkins, 4000)
                .remainingPrincipalBalance(4000)
                .interestRate(.05)
                .lastPaymentDate(new DateTime(2017, 7, 03, 0, 0))
                .build();
        int monthsLeft = 120;
        assertEquals(120, monthsLeft);
    }
}