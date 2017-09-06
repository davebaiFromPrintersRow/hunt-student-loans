package loans.v1;

public class PerkinsC implements Loan  {

    @Override
    public double getMinimumPaymentPerMonth() {
        return 47.73;
    }

    @Override
    public double getInterestRate() {
        return 0.05;
    }

    @Override
    public double getOriginalDisbursement() {
        return 4500;
    }

    @Override
    public double getRemainingPrincipal() {
        return 0;
    }

    @Override
    public void setRemainingPrincipal(double remainingPrincipal) {

    }
}
