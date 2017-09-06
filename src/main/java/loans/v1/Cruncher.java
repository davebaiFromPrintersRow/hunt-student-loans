package loans.v1;

import loans.v0.Calculator;

public class Cruncher {

    public static final double AMORTIZED_DAYS_PER_MONTH = 30.5;

    public static int getMonthsLeftToPay(Loan loan) {
        double minimumPaymentPerMonth = loan.getMinimumPaymentPerMonth();

        double runningPrincipal = loan.getRemainingPrincipal();
        int monthsPay = 0;
        while (runningPrincipal > 0) {
            double interestAccruementForTheMonth = Calculator.getInterestAccruement(runningPrincipal, AMORTIZED_DAYS_PER_MONTH, loan.getInterestRate());
            double moneyLeftForPrincipal = minimumPaymentPerMonth - interestAccruementForTheMonth; // don't forget, interest is applied first
            runningPrincipal -= moneyLeftForPrincipal;
            monthsPay++;
        }
        return monthsPay;
    }
}
