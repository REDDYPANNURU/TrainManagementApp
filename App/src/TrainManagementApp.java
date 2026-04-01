import java.util.*;
import java.util.stream.*;

class Bogie {
    String bogieId;
    int capacity;

    Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
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

    void addBogie(String id, int capacity) {
        bogies.add(new Bogie(id, capacity));
    }

    void countTotalSeats() {
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Train: " + trainName);
        System.out.println("Total Seats: " + total);
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 1001");

        train.addBogie("B1", 72);
        train.addBogie("B2", 64);
        train.addBogie("B3", 48);
        train.addBogie("B4", 90);

        train.countTotalSeats();
    }
}