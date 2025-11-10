import java.util.Arrays;

public class dynamicArray {
    static int max_size = 2;
    static int size = 0;
    static int [] data = new int[max_size];

    public static void main (String[] args) {

        add(10);
        add(4);
        add(15);
        add(1);
        add(4);
        add(8);
        print();
        sort();
        print();

    }


    static void add(int value) {
        if (size >= data.length) {
            int[] temp =  Arrays.copyOf(data, size);
            max_size *=2;
            data = new int[max_size];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;

    }


    static void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }


    static void sort() {
        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length-i-1; j++){
                if (data[j] > data[j+1]) {
                    int x = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = x;
                }
            }

        }
    }


}

