package loans.v1;

public interface Loan {

    public double getMinimumPaymentPerMonth();

    public double getInterestRate();

    public double getOriginalDisbursement();

    public double getRemainingPrincipal();

    public void setRemainingPrincipal(double remainingPrincipal);

}
