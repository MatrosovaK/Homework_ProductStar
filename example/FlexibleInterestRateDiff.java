package org.example;

import java.util.ArrayList;
import java.util.List;

public class FlexibleInterestRateDiff implements IFlexibleRateCalc {
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
        payments = new ArrayList<>();
        double principalPayment;
        double remainingDebt = loanAmount;
        int totalMonths = (int) (years * 12);
        principalPayment = loanAmount / totalMonths;
        double monthlyRate;

        for(int month = 1; month <= totalMonths; month++){
                if(month <= firstTermYears*12){
                    monthlyRate = firstAnnualInterestRate / 12 / 100;
                }else{
                    monthlyRate = annualInterestRate / 12 / 100;

                }

            double interestPayment = remainingDebt * monthlyRate;
            payments.add(new Payment(month, principalPayment, interestPayment));
            remainingDebt -= principalPayment;


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