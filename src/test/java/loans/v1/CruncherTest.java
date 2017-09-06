package loans.v1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CruncherTest {

    @Test
    public void perkinsLoanAShouldBePaidOffIn120Months() throws Exception {
        PerkinsA perkinsA = new PerkinsA(4000);
        int monthsLeftToPay = Cruncher.getMonthsLeftToPay(perkinsA);
        assertEquals(121, monthsLeftToPay);
    }
}