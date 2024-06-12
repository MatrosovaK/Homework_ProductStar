public class HW4{
    public static void main(String[] args) {
        int n = 22;
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


