package loans.v2;

public class TheDamage {

    private int paymentsLeft;
    private double interestPaid;

    public TheDamage(int paymentsLeft, double interestPaid) {
        this.paymentsLeft = paymentsLeft;
        this.interestPaid = interestPaid;
    }

    public int getPaymentsLeft() {
        return paymentsLeft;
    }

    public void setPaymentsLeft(int paymentsLeft) {
        this.paymentsLeft = paymentsLeft;
    }

    public double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(double interestPaid) {
        this.interestPaid = interestPaid;
    }
}
