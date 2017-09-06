package loans.v2;

public class PerkinsLoan {

    private double principalBalance;

    public PerkinsLoan(double principalBalance) {
        this.principalBalance = principalBalance;
    }

    public double getPrincipalBalance() {
        return principalBalance;
    }

    public void setPrincipalBalance(double principalBalance) {
        this.principalBalance = principalBalance;
    }

    public static void main(String[] args) {
        double principal = 4000;
        double totalInterest = 0;
        double minimumPaymentPerkinsA = 42.43;

        int payments = 0;
        while (principal > 0) {
            double interest = SimpleInterest.calculateTotalInterest(principal, 5.0, 31);
            double appliedPrincipalPayment = minimumPaymentPerkinsA - interest;
            totalInterest += interest;
            payments++;
            principal -= appliedPrincipalPayment;
        }

        System.out.println("total payments: " + payments);
        System.out.println("total interest: " + totalInterest);
    }
}
