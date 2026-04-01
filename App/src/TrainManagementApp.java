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

    void groupByType() {
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        System.out.println("Train: " + trainName);

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b.bogieId + " - Capacity: " + b.capacity);
            }
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 909");

        train.addBogie("B1", "Passenger", 72);
        train.addBogie("B2", "Cargo", 100);
        train.addBogie("B3", "Passenger", 64);
        train.addBogie("B4", "Engine", 0);
        train.addBogie("B5", "Cargo", 120);

        train.groupByType();
    }
}