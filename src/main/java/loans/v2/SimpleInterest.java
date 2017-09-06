package loans.v2;

public class SimpleInterest {

    private static final double DAYS_PER_YEAR = 365.25;

    public static double calculateTotalInterest(double principalBalance, double interestRatePerAnnum, int days) {
        return principalBalance * days * interestRatePerAnnum / (100.0 * DAYS_PER_YEAR);
    }
}
