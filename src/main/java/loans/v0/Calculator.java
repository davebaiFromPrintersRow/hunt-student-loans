package loans.v0;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.logging.Logger;

public class Calculator {

    private final Logger _logger = Logger.getLogger(this.getClass().getName());

    private static final double DAYS_IN_YEAR = 365.25;

    public static void main(String[] args) {
        double interestAccruement = getInterestAccruement(3750.14, 28, .05);
        System.out.println(interestAccruement);
    }

    public static double getInterestAccruement(double currentPrincipalBalance, double daysSinceLastPayment, double interestRate) {
        double interestRateFactor = getInterestRateFactor(interestRate);
        double todaysInterest = 0;
        double runningInterest = 0;
        double runningPrincipalBalance = currentPrincipalBalance;

        for (int i = 0; i < daysSinceLastPayment; i++) {
            todaysInterest = runningPrincipalBalance * interestRateFactor;

            runningInterest += todaysInterest;
            runningPrincipalBalance += todaysInterest;
        }
        return runningInterest;
    }

    public static double getInterestRateFactor(double interestRate) {
        return interestRate / DAYS_IN_YEAR;
    }

    public static int getDaysSinceLastPayment(DateTime lastPaymentDate, DateTime dateOfPayment) {
        return Days.daysBetween(lastPaymentDate.toLocalDate(), dateOfPayment.toLocalDate()).getDays();
    }
}
