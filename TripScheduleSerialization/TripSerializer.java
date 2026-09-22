package org.TripScheduleSerialization;

import java.io.*;
import java.util.List;

public class TripSerializer {
    public static void save(List<Trip>trips) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trips.ser"))){
            oos.writeObject(trips);
        }

    }

    public static List<Trip> load() throws IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trips.ser"))){
            return (List<Trip>) ois.readObject();
        }

    }


}
