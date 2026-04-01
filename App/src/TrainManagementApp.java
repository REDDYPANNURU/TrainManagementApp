import java.util.*;

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

    void sortByCapacity() {
        Collections.sort(bogies, new Comparator<Bogie>() {
            public int compare(Bogie b1, Bogie b2) {
                return Integer.compare(b1.capacity, b2.capacity);
            }
        });
    }

    void display() {
        System.out.println("Train: " + trainName);
        for (Bogie b : bogies) {
            System.out.println(b.bogieId + " - Capacity: " + b.capacity);
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 707");

        train.addBogie("B1", 72);
        train.addBogie("B2", 64);
        train.addBogie("B3", 48);
        train.addBogie("B4", 90);

        train.sortByCapacity();
        train.display();
    }
}