import java.util.Scanner;

public class HWfizzbuzz{
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 & i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0 & i % 5 != 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0 & i % 3 != 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}


