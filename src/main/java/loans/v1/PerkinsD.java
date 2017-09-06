package loans.v1;

public class PerkinsD implements Loan {

    @Override
    public double getMinimumPaymentPerMonth() {
        return 23.86;
    }

    @Override
    public double getInterestRate() {
        return 0.05;
    }

    @Override
    public double getOriginalDisbursement() {
        return 2250;
    }

    @Override
    public double getRemainingPrincipal() {
        return 0;
    }

    @Override
    public void setRemainingPrincipal(double remainingPrincipal) {

    }
}
