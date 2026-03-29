package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double principal;
        while(true){
            System.out.println("Введите общую стоимость объекта (квартиры/товара): ");
            principal = in.nextDouble();
            if(principal <=0){
                System.out.println("Некорректное значение. Сумма долга должна быть больше 0");
            } else{
                break;
            }

        }

        double downPayment;
        while(true){
            System.out.println("Введите первоначальный взнос (если нет - введите 0): ");
            downPayment = in.nextDouble();
            if(downPayment < 0){
                System.out.println("Некорректное значение. Первоначальный взнос должен быть больше  или равен 0");
            } else{
                break;
            }

        }

        IFlexibleRateCalc flexibleRateCalc;
        int flexibleInterestRate;
        double firstAnnualInterestRate;
        int firstTermYears;
        int years;
        double annualInterestRate;
        while(true){
            System.out.println("Есть ли у вас льготная процентная ставка с фиксированным периодом? (1 - да, 2 - нет)");
            flexibleInterestRate = in.nextInt();
            if(flexibleInterestRate <= 0 ||  flexibleInterestRate > 2){
                System.out.println("Неверное значение");
            } else if (flexibleInterestRate == 2){
                break;
            } else{
                flexibleRateCalc = new FlexibleInterestRateDiff();

                while(true){
                    System.out.println("Введите процентную ставку на льготный период: ");
                    firstAnnualInterestRate = in.nextDouble();
                    if(firstAnnualInterestRate<=0){
                        System.out.println("Ставка должна быть больше 0");
                    } else {
                        break;
                    }

                }

                while(true) {
                    System.out.println("Введите срок льготного периода (в годах): ");
                    firstTermYears = in.nextInt();
                    if(firstTermYears<=0){
                        System.out.println("Некорректное значение. Срок льготного периода должен быть больше 0");
                    }else{
                        break;
                    }
                }

                while(true) {
                    System.out.println("Введите общий срок кредита в годах: ");
                    years = in.nextInt();
                    if (years <= 0) {
                        System.out.println("Некорректное значение. Срок кредита должен быть больше 0");
                    } else {
                        break;
                    }
                }

                while(true){
                    System.out.println("Введите вашу основную процентную ставку: ");
                    annualInterestRate = in.nextDouble();
                    if(annualInterestRate <= 0){
                        System.out.println("Некорректное значение. Процентная ставка должна быть больше 0");
                    } else{
                        break;
                    }

                }

                while (true){
                    System.out.println("Введите вид платежа (1- аннуитетный, 2-дифференцированный, 3-сомневаюсь, что выбрать: ");
                    int paymentType = in.nextInt();

                    if (paymentType == 1) {
                        flexibleRateCalc = new FlexibleInterestRateAnn();
                        break;
                    } else if (paymentType == 2) {
                        flexibleRateCalc = new FlexibleInterestRateDiff();
                        break;
                    }else if (paymentType == 3){
                        System.out.println("вывожу краткое сравнение двух типов платежей: ");

                        IFlexibleRateCalc flexAnnuity = new FlexibleInterestRateAnn();
                        IFlexibleRateCalc flexDiff = new FlexibleInterestRateDiff();

                        flexAnnuity.setPrincipal(principal);
                        flexAnnuity.setYears(years);
                        flexAnnuity.setFirstTermYears(firstTermYears);
                        flexAnnuity.setFirstAnnualInterestRate(firstAnnualInterestRate);
                        flexAnnuity.setAnnualInterestRate(annualInterestRate);
                        flexAnnuity.setDownPayment(downPayment);
                        flexAnnuity.calculatePayments();

                        flexDiff.setPrincipal(principal);
                        flexDiff.setYears(years);
                        flexDiff.setAnnualInterestRate(annualInterestRate);
                        flexDiff.setDownPayment(downPayment);
                        flexDiff.setFirstTermYears(firstTermYears);
                        flexDiff.setFirstAnnualInterestRate(firstAnnualInterestRate);
                        flexDiff.calculatePayments();



                        System.out.printf("Аннуитетный кредит: Общая сумма выплат: %.2f, Общая сумма процентов: %.2f, Переплата составит: %.2f%n",
                                flexAnnuity.getTotalPayment(), flexAnnuity.getTotalInterest(),flexAnnuity.getTotalOverpayment());
                        System.out.printf("Дифференцированный кредит: Общая сумма выплат: %.2f, Общая сумма процентов: %.2f, Переплата составит: %.2f%n",
                                flexDiff.getTotalPayment(), flexDiff.getTotalInterest(),flexDiff.getTotalOverpayment());;


                    }else {

                        System.out.println("Неверный тип платежа");

                    }
                }


                flexibleRateCalc.setFirstAnnualInterestRate(firstAnnualInterestRate);
                flexibleRateCalc.setFirstTermYears(firstTermYears);
                flexibleRateCalc.setPrincipal(principal);
                flexibleRateCalc.setYears(years);
                flexibleRateCalc.setAnnualInterestRate(annualInterestRate);
                flexibleRateCalc.setDownPayment(downPayment);

                flexibleRateCalc.calculatePayments();

                printSchedule(flexibleRateCalc);
                return;
            }

        }

        while(true){
            System.out.println("Введите общий срок кредита в годах: ");
            years = in.nextInt();
            if(years <= 0){
                System.out.println("Некорректное значение. Срок кредита должен быть больше 0");
            } else{
                break;
            }

        }

        while(true){
            System.out.println("Введите вашу процентную ставку: ");
            annualInterestRate = in.nextDouble();
            if(annualInterestRate <= 0){
                System.out.println("Некорректное значение. Процентная ставка должна быть больше 0");
            } else{
                break;
            }

        }


        ICalculator calculator;
        while (true){
            System.out.println("Введите вид платежа (1- аннуитетный, 2-дифференцированный, 3-сомневаюсь, что выбрать: ");
            int paymentType = in.nextInt();

            if (paymentType == 1) {
                calculator = new AnnuityCalculator();
                break;
            } else if (paymentType == 2) {
                calculator = new DifferentiatedCalculator();
                break;
            }else if (paymentType == 3){
                System.out.println("вывожу краткое сравнение двух типов платежей: ");

                ICalculator annuity = new AnnuityCalculator();
                ICalculator diff = new DifferentiatedCalculator();

                annuity.setPrincipal(principal);
                annuity.setYears(years);
                annuity.setAnnualInterestRate(annualInterestRate);
                annuity.setDownPayment(downPayment);
                annuity.calculatePayments();

                diff.setPrincipal(principal);
                diff.setYears(years);
                diff.setAnnualInterestRate(annualInterestRate);
                diff.setDownPayment(downPayment);
                diff.calculatePayments();


                System.out.printf("Аннуитетный кредит: Общая сумма выплат: %.2f, Общая сумма процентов: %.2f, Переплата составит: %.2f%n",
                        annuity.getTotalPayment(), annuity.getTotalInterest(),annuity.getTotalOverpayment());
                System.out.printf("Дифференцированный кредит: Общая сумма выплат: %.2f, Общая сумма процентов: %.2f, Переплата составит: %.2f%n",
                        diff.getTotalPayment(), diff.getTotalInterest(),diff.getTotalOverpayment());;


            }else {

                System.out.println("Неверный тип платежа");

            }
        }

        calculator.setPrincipal(principal);
        calculator.setYears(years);
        calculator.setAnnualInterestRate(annualInterestRate);
        calculator.setDownPayment(downPayment);

        calculator.calculatePayments();

        printSchedule(calculator);

    }
    private static void printSchedule(ICalculator calculator){
        System.out.println("График платежей: ");
        for (Payment payment: calculator.getPaymentsSchedule()){
            System.out.printf("Месяц: %d, Платеж по основному долгу: %.2f, Процентный платеж: %.2f, Общий платеж: %.2f%n",
                    payment.getMonth(), payment.getPrincipalPayment(), payment.getInterestPayment(), payment.getTotalPayment());
        }

        System.out.printf("Общая сумма выплат: %.2f%n", calculator.getTotalPayment());
        System.out.printf("Общая сумма процентов: %.2f%n", calculator.getTotalInterest());
        System.out.printf("Переплата составляет: %.2f%n", calculator.getTotalOverpayment());

    }
        }







