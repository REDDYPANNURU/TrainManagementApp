import java.util.*;

class Train {
    String trainName;
    HashSet<String> bogieIds;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogieIds = new HashSet<>();
    }

    void addBogie(String bogieId) {
        if (bogieIds.add(bogieId)) {
            System.out.println("Added Bogie: " + bogieId);
        } else {
            System.out.println("Duplicate Bogie ID: " + bogieId);
        }
    }

    void displayBogies() {
        System.out.println("Train: " + trainName);
        for (String id : bogieIds) {
            System.out.println(id);
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 303");

        train.addBogie("B1");
        train.addBogie("B2");
        train.addBogie("B3");
        train.addBogie("B2");
        train.addBogie("B4");

        train.displayBogies();
    }
}