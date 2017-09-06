package loans.v1;

public class PerkinsA implements Loan {

    private double remainingPrincipal;

    public PerkinsA(double remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }

    @Override
    public double getMinimumPaymentPerMonth() {
        return 42.43;
    }

    @Override
    public double getInterestRate() {
        return 0.05;
    }

    @Override
    public double getOriginalDisbursement() {
        return 4000;
    }

    @Override
    public double getRemainingPrincipal() {
        return remainingPrincipal;
    }

    @Override
    public void setRemainingPrincipal(double remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }
}
