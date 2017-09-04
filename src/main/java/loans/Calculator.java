package loans;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.logging.Logger;

public class Calculator {

    private final Logger _logger = Logger.getLogger(this.getClass().getName());

    private static final double DAYS_IN_YEAR = 365.25;

    public static double getInterestAccruement(double currentPrincipalBalance, int daysSinceLastPayment, double interestRate) {
        double interestRateFactor = getInterestRateFactor(interestRate);
        double runningInterestAmount = 0;
        double runningPrincipalBalance = currentPrincipalBalance;

        for (int i = 0; i < daysSinceLastPayment; i++) {
            runningInterestAmount += runningPrincipalBalance * interestRateFactor;
            runningPrincipalBalance += runningInterestAmount;
        }
        return runningInterestAmount;
    }

    public static double getInterestRateFactor(double interestRate) {
        return interestRate / DAYS_IN_YEAR;
    }

    public static int getDaysSinceLastPayment(DateTime lastPaymentDate, DateTime dateOfPayment) {
        return Days.daysBetween(lastPaymentDate.toLocalDate(), dateOfPayment.toLocalDate()).getDays() + 1;
    }
}
