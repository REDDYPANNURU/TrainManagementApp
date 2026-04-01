import java.util.*;
import java.util.stream.*;

class Bogie {
    String bogieId;
    String type;
    int capacity;

    Bogie(String bogieId, String type, int capacity) {
        this.bogieId = bogieId;
        this.type = type;
        this.capacity = capacity;
    }
}

class Train {
    String trainName;
    List<Bogie> bogies;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    void addBogie(String id, String type, int capacity) {
        bogies.add(new Bogie(id, type, capacity));
    }

    void filterPassengerBogies() {
        List<Bogie> result = bogies.stream()
                .filter(b -> b.type.equalsIgnoreCase("Passenger"))
                .collect(Collectors.toList());

        System.out.println("Train: " + trainName);
        for (Bogie b : result) {
            System.out.println(b.bogieId + " - " + b.type + " - Capacity: " + b.capacity);
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 808");

        train.addBogie("B1", "Passenger", 72);
        train.addBogie("B2", "Cargo", 100);
        train.addBogie("B3", "Passenger", 64);
        train.addBogie("B4", "Engine", 0);

        train.filterPassengerBogies();
    }
}