import java.util.*;

class Train {
    String trainName;
    HashMap<String, Integer> bogieCapacityMap;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogieCapacityMap = new HashMap<>();
    }

    void addBogie(String bogieId, int capacity) {
        bogieCapacityMap.put(bogieId, capacity);
    }

    void displayBogieCapacity() {
        System.out.println("Train: " + trainName);
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " - Capacity: " + entry.getValue());
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 606");

        train.addBogie("B1", 72);
        train.addBogie("B2", 64);
        train.addBogie("B3", 48);
        train.addBogie("B4", 90);

        train.displayBogieCapacity();
    }
}