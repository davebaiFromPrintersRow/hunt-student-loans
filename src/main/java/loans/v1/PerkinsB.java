package loans.v1;

public class PerkinsB implements Loan  {
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
}
