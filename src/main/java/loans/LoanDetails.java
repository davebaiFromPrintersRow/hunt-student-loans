package loans;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;
import java.util.logging.Logger;

public class LoanDetails {

    private final Logger _logger = Logger.getLogger(this.getClass().getName());

    private static final double DAYS_IN_YEAR = 365.25;

    private final LoanType loanType;
    private final double originalDisbursementAmount;
    private final double remainingPrincipalBalance;
    private final double interestRate;
    private final DateTime lastPaymentDate;

    public double getInterestPaymentOnUpcomingBill(DateTime dateOfPayment) {
        int daysBetweenPayment = Calculator.getDaysSinceLastPayment(lastPaymentDate, dateOfPayment);
        return Calculator.getInterestAccruement(remainingPrincipalBalance, daysBetweenPayment, interestRate);

    }

    private double getInterestRateFactor() {
        return interestRate / DAYS_IN_YEAR;
    }

    private LoanDetails(LoanDetailsBuilder builder) {
        this.loanType = builder.loanType;
        this.originalDisbursementAmount = builder.originalDisbursementAmount;
        this.remainingPrincipalBalance = builder.remainingPrincipalBalance;
        this.interestRate = builder.interestRate;
        this.lastPaymentDate = builder.lastPaymentDate;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public double getOriginalDisbursementAmount() {
        return originalDisbursementAmount;
    }

    public double getRemainingPrincipalBalance() {
        return remainingPrincipalBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public DateTime getLastPaymentDate() {
        return lastPaymentDate;
    }

    public static class LoanDetailsBuilder {
        private LoanType loanType;
        private double originalDisbursementAmount;

        private double remainingPrincipalBalance;
        private double interestRate;
        private DateTime lastPaymentDate;

        public LoanDetailsBuilder(LoanType loanType, double originalDisbursementAmount) {
            this.loanType = loanType;
            this.originalDisbursementAmount = originalDisbursementAmount;
        }

        public LoanDetailsBuilder remainingPrincipalBalance(double remainingPrincipalBalance) {
            this.remainingPrincipalBalance = remainingPrincipalBalance;
            return this;
        }

        public LoanDetailsBuilder interestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public LoanDetailsBuilder lastPaymentDate(DateTime lastPaymentDate) {
            this.lastPaymentDate = lastPaymentDate;
            return this;
        }

        public LoanDetails build() {
            return new LoanDetails(this);
        }
    }
}
