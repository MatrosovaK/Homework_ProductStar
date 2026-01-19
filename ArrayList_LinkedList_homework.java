import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ArrayList_LinkedList_homework {

    private static final Random random = new Random(1000000);

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int listSize = 1000000;
        generate(arrayList, 1000000);
        generate(linkedList, 1000000);


        int[] randomIndices = new int[1000];
        for (int i = 0; i < randomIndices.length;i++){
            randomIndices[i] = random.nextInt(listSize);
        }


        long startArrayList = System.nanoTime();
        for (int i = 0; i < randomIndices.length; i ++){
            arrayList.get(randomIndices[i]);
        }
        long endArrayList = System.nanoTime();
        long timeArrayList = endArrayList - startArrayList;
        System.out.println("Время для ArrayList составляет: " + timeArrayList + " нс");



        long startLinkedList = System.nanoTime();
        for(int i = 0; i < randomIndices.length; i++){
            linkedList.get(randomIndices[i]);
        }
        long endLinkedList = System.nanoTime();
        long timeLinkedList = endLinkedList - startLinkedList;
        System.out.println("Время для LinkedList составляет: " + timeLinkedList + " нс");


    }

    public static void generate(List<Integer> list, int listSize) {
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(1000000));

        }

    }
}