package loans.v0;

import org.joda.time.DateTime;

import java.util.logging.Logger;

public class LoanDetails {

    private final Logger _logger = Logger.getLogger(this.getClass().getName());

    private static final double DAYS_IN_YEAR = 365.25;

    private final LoanType loanType;
    private final double originalDisbursementAmount;
    private double remainingPrincipalBalance;
    private final double interestRate;
    private final DateTime lastPaymentDate;

    public static void main(String[] args) {
        LoanDetails perkins4000 = new LoanDetailsBuilder(LoanType.Federal_Perkins, 4000)
                .remainingPrincipalBalance(4000)
                .interestRate(.05)
                .lastPaymentDate(new DateTime(2017, 7, 03, 0, 0))
                .build();
        double perkinsAMinimumPayment = 42.43;
        String paymentPlan = perkins4000.getPaymentPlan(perkinsAMinimumPayment);
        System.out.println(paymentPlan);
    }

    public double applyPayment(double paymentAmount, int daysSinceLastPayment) {
        double interestAccruement = Calculator.getInterestAccruement(remainingPrincipalBalance, daysSinceLastPayment, interestRate);
        double principalApplied = paymentAmount - interestAccruement;
        remainingPrincipalBalance -= principalApplied;
        return principalApplied;
    }

    private String getPaymentPlan(double paymentPerMonth) {
        StringBuilder sb = new StringBuilder();
        sb.append("*********************************************************^^*********************************************************");
        sb.append("\n");
        int countMonths = 0;
        double totalInterestPaid = 0;
        while (remainingPrincipalBalance > 0) {
            double principalApplied = applyPayment(paymentPerMonth, 31);// just to be save and overestimate interest amount, use 31 days per month as average
            sb.append("month: " + countMonths);
            sb.append("\t");
            sb.append("apply: " + paymentPerMonth);
            sb.append("\t");
            double interest = paymentPerMonth - principalApplied;
            totalInterestPaid += interest;
            sb.append("interest: " + String.format("%.2f", (interest)));
            sb.append("\t");
            sb.append("principal: " + String.format("%.2f", principalApplied));
            sb.append("\t");
            sb.append("remain: " + String.format("%.2f", remainingPrincipalBalance));
            sb.append("\n");
            countMonths++;
        }
        sb.append("*********************************************************^^*********************************************************");
        sb.append("\n");
        sb.append("Total interest: " + totalInterestPaid);
        return sb.toString();
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
