import java.util.Arrays;
import java.util.Random;

public class SortingMethods {


    public static void main(String[]args){
        int arraySize = 1000;
        int[] array = new int[arraySize];
        generate(array, arraySize);
        long startBS = System.nanoTime();
        bubbleSort(array);
        long endBS = System.nanoTime();
        long timeBS = endBS - startBS;
        System.out.println("Время для bubble sort составляет: " + timeBS + " нс");

        long startSS = System.nanoTime();
        selectionSort(array);
        long endSS = System.nanoTime();
        long timeSS = endSS - startSS;
        System.out.println("Время для selection sort составляет: " + timeSS + " нс");

        long startTS = System.nanoTime();
        Arrays.sort(array);
        long endTS = System.nanoTime();
        long timeTS = endTS - startTS;
        System.out.println("Время для Timsort составляет: " + timeTS + " нс");

    }

    public static void generate(int[] array, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            array[i] = new Random().nextInt(1000) ;
        }
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }



}
