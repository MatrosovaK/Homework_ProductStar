import java.util.HashMap;
import java.util.Map;

public class HashMap_VINandID {
public static void main(String[] args) {
    HashMap<String, Integer> VINandID = new HashMap<>(); //key - VIN автомобиля, value - регистрационный ID, и VIN, и ID уникальны
    HashMap<Integer, String> IDandVIN = new HashMap<>(); //наоборот

    VINandID.put("XTA210740Y1234567", 2111);
    VINandID.put("XTA982922Y1234567", 9983);
    VINandID.put("BNA210740Y1234615", 7288);
    VINandID.put("NML210740Y9999999", 9829);
    VINandID.put("XTA210740Y1111111", 1523);
    VINandID.put("AAA210740B1234567", 2355);
    VINandID.put("XXX210740Y1234567", 9878);

    System.out.println("VIN and ID: " + VINandID);
    System.out.println("VIN and ID size: " + VINandID.size());

    for (Map.Entry<String, Integer> entry: VINandID.entrySet()){
        IDandVIN.put(entry.getValue(), entry.getKey());

    }
    System.out.println("ID and VIN: " + IDandVIN);
    System.out.println("ID and VIN size: " + IDandVIN.size());
}
}


