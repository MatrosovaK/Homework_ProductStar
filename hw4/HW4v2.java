public class HW4v2{
    public static void main(String[] args) {
        int n = 26;
        int i = 0;
        System.out.print(i + " ");
        for (i = 1; i <= n; i++) {
            if (i % 3 == 0 & i % 5 == 0) {
                System.out.print("fizzbuzz ");
            } else if (i % 5 == 0 & i % 3 != 0) {
                System.out.print("buzz ");
            } else if (i % 3 == 0 & i % 5 != 0) {
                System.out.print("fizz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}


