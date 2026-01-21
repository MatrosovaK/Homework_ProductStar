import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageForSubArray {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,5));
        int k = 2;

        printAverages(array, k);

    }

    public static void printAverages(List<Integer>array, int k){
        List<Double> averages = new ArrayList<>();

        double sum = 0;

        for (int i = 0; i < k; i++){
            sum += array.get(i);

        }

        averages.add(sum/k);

        for (int i = k; i < array.size(); i++){
            sum = sum + array.get(i) - array.get(i-k);
            averages.add(sum/k);

        }
        System.out.println(averages);
    }

}