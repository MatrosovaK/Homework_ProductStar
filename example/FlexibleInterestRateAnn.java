package org.example;

import java.util.ArrayList;
import java.util.List;

public class FlexibleInterestRateAnn implements IFlexibleRateCalc {
    private double principal;

    private int firstTermYears;
    private List<Payment> payments;
    private double downPayment;
    private double firstAnnualInterestRate;
    private int years;
    private double annualInterestRate;


    @Override
    public void setFirstAnnualInterestRate(double firstAnnualInterestRate) {
        this.firstAnnualInterestRate = firstAnnualInterestRate;
    }

    @Override
    public void setFirstTermYears(int firstTermYears) {
        this.firstTermYears = firstTermYears;
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
        int totalMonths = years * 12;
        int firstTermMonths = firstTermYears * 12;

        payments = new ArrayList<>();
        double monthlyRate1 = firstAnnualInterestRate / 12 / 100;
        double monthlyPayment1 = loanAmount * (monthlyRate1 * Math.pow(1+monthlyRate1, totalMonths))
                / (Math.pow(1+monthlyRate1, totalMonths)-1);
        for(int month = 1; month <= firstTermMonths; month++) {

            double interestPayment = loanAmount*monthlyRate1;
            double principalPayment = monthlyPayment1 - interestPayment;
            payments.add(new Payment(month, principalPayment, interestPayment));
            loanAmount -=principalPayment;
            }

        int secondTermMonths = totalMonths - firstTermMonths;
        double monthlyRate2 = annualInterestRate / 12 / 100;
        double monthlyPayment2= loanAmount * (monthlyRate2 * Math.pow(1+monthlyRate2, secondTermMonths))
                / (Math.pow(1+monthlyRate2, secondTermMonths)-1);

        for(int month = firstTermMonths+1; month <= totalMonths; month++) {

            double interestPayment = loanAmount*monthlyRate2;
            double principalPayment = monthlyPayment2- interestPayment;
            payments.add(new Payment(month, principalPayment, interestPayment));
            loanAmount -=principalPayment;
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

    @Override
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }
}

