package loans.v1;

public class PerkinsA implements Loan {
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
}
