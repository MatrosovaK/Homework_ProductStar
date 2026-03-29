package org.example;

public class Payment {
    private final int month;
    private final double principalPayment;
    private final double interestPayment;
    private final double totalPayment;
    private final double totalOverpayment;


    public Payment(int month, double principalPayment, double interestPayment) {
        this.month = month;
        this.principalPayment = principalPayment;//общая сумма кредита
        this.interestPayment = interestPayment;
        this.totalPayment = principalPayment + interestPayment;
        this.totalOverpayment = interestPayment;

    }



    public int getMonth() {
        return month;
    }

    public double getPrincipalPayment() {
        return principalPayment;
    }

    public double getInterestPayment() {
        return interestPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalOverpayment() {
        return totalOverpayment;
    }
}