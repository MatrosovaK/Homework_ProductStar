public class HW4v2{
    public static void main(String[] args) {
        int n = 22;
        int i = 0;
        System.out.println(i);
        for (i = 1; i <= n; i++) {
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


