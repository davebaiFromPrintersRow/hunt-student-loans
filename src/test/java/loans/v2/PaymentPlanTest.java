package loans.v2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PaymentPlanTest {

    private static final double ONE_DOLLAR = 1.0;

    @Test
    public void perkinsALoan() throws Exception {
        PaymentPlan paymentPlan = new PaymentPlan(42.43);
        PerkinsLoan perkinsLoanA = new PerkinsLoan(3221.29);

        TheDamage theDamage = paymentPlan.paymentsLeft(perkinsLoanA);
        assertEquals(92, theDamage.getPaymentsLeft());
        assertEquals(675.00, theDamage.getInterestPaid(), ONE_DOLLAR);
    }

    @Test
    public void perkinsBLoan() throws Exception {
        PaymentPlan paymentPlan = new PaymentPlan(47.73);
        PerkinsLoan perkinsLoanB = new PerkinsLoan(3624.06);

        TheDamage theDamage = paymentPlan.paymentsLeft(perkinsLoanB);
        assertEquals(92, theDamage.getPaymentsLeft());
        assertEquals(760.00, theDamage.getInterestPaid(), ONE_DOLLAR);
    }

    @Test
    public void perkinsCLoan() throws Exception {
        PaymentPlan paymentPlan = new PaymentPlan(47.73);
        PerkinsLoan perkinsLoanC = new PerkinsLoan(3624.06);

        TheDamage theDamage = paymentPlan.paymentsLeft(perkinsLoanC);
        assertEquals(92, theDamage.getPaymentsLeft());
        assertEquals(760.00, theDamage.getInterestPaid(), ONE_DOLLAR);
    }

    @Test
    public void perkinsDLoan() throws Exception {
        PaymentPlan paymentPlan = new PaymentPlan(23.86);
        PerkinsLoan perkinsLoanD = new PerkinsLoan(1812.11);

        TheDamage theDamage = paymentPlan.paymentsLeft(perkinsLoanD);
        assertEquals(92, theDamage.getPaymentsLeft());
        assertEquals(380.00, theDamage.getInterestPaid(), ONE_DOLLAR);
    }
}