import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListDuplicates {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Jurijs");
        names.add("Lev");
        names.add("Ekaterina");
        names.add("Viktor");
        names.add("Lev");
        names.add("Ilija");
        names.add("Ekaterina");
        names.add("Viktor");
        names.add("Ilija");
        names.add("Viktor");
        names.add("Ekaterina");
        System.out.println(names);


    HashSet<String> namesSet = new HashSet<>();
    namesSet.addAll(names);
    System.out.println(namesSet);



    }
}
