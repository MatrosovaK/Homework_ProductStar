import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        ArrayList<Double> results = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        while (true){
            double first;
            double second;
            while(true){
                System.out.print("Введите первое число: ");
                if (scan.hasNextDouble()){
                    first = scan.nextDouble();
                } else {
                    System.out.println("некорректное число");
                    scan.next();
                    continue;
                }

                System.out.print("Введите второе число: ");
                if (scan.hasNextDouble()){
                    second = scan.nextDouble();
                } else {
                    System.out.println("некорректное число");
                    scan.next();
                    continue;
                }
                break;

            }


            System.out.print("Введите оператор: (+, -, *, /): ");

            String operatorStr = scan.next();
            if (operatorStr.length() > 1) {
                System.out.println("некорректный оператор");
                continue;
            }

            char operator = operatorStr.charAt(0);

            double result;

            if (operator == '+') {
                result = first + second;
            } else if (operator == '-') {
                result = first - second;
            } else if (operator == '*') {
                result = first * second;
            } else if (operator == '/') {
                result = first / second;
            } else {
                System.out.println("некорректный оператор");
                continue;
            }

            results.add(result);
            System.out.println("Результат: " + result);
            System.out.println("Результат записан. Вы хотите выйти?");
            String input = scan.next();

            if (input.equals("да") || input.equals("yes")) {
                System.out.println("Выход из программы и вывод результатов: ");
                System.out.println(results);
                scan.close();
                break;
            }

        }
    }
}






