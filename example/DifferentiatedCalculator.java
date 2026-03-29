package org.example;

import java.util.ArrayList;
import java.util.List;

public class DifferentiatedCalculator implements ICalculator {
    private double principal;
    private double annualInterestRate;
    private int years;
    private List<Payment> payments;
    private double downPayment;


    @Override
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    @Override
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public void calculatePayments() {
        double loanAmount = principal - downPayment; //оставшаяся сумма кредита
        double monthlyRate = annualInterestRate / 12 / 100;
        payments = new ArrayList<>();
        double principalPayment = loanAmount / (years *12);
        double remainingPayment = loanAmount;

        for(int month = 1; month <= years *12; month++){

            double interestPayment = remainingPayment * monthlyRate;
            payments.add(new Payment(month, principalPayment, interestPayment));
            remainingPayment -= principalPayment;
        }
    }

    @Override
    public double getTotalPayment() {
        return payments.stream().mapToDouble(Payment::getTotalPayment).sum();
    }

    @Override
    public double getTotalInterest() {
        return payments.stream().mapToDouble(Payment::getInterestPayment).sum();
            }

    @Override
    public List<Payment> getPaymentsSchedule() {
        return payments;
    }

    @Override
    public double getTotalOverpayment() {
        return payments.stream().mapToDouble(Payment::getTotalOverpayment).sum();
    }
}
