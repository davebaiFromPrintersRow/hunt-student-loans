package loans.v2;

public class PaymentPlan {

    private double paymentPerMonth;

    public PaymentPlan(double paymentPerMonth) {
        this.paymentPerMonth = paymentPerMonth;
    }

    public TheDamage paymentsLeft(PerkinsLoan perkinsLoanA) {
        int payments = 0;
        double principalBalance = perkinsLoanA.getPrincipalBalance();
        double totalInterest = 0;
        while (principalBalance > 0) {
            double interest = SimpleInterest.calculateTotalInterest(principalBalance, 5.0, 31);
            double appliedPrincipalPayment = paymentPerMonth - interest;
            totalInterest += interest;
            payments++;
            principalBalance -= appliedPrincipalPayment;
        }
        return new TheDamage(payments, totalInterest);
    }

    public double getPaymentPerMonth() {
        return paymentPerMonth;
    }

    public void setPaymentPerMonth(double paymentPerMonth) {
        this.paymentPerMonth = paymentPerMonth;
    }
}
