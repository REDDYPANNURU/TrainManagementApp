import java.util.*;

class Passenger {
    String name;
    int age;

    Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Bogie {
    String bogieId;
    int capacity;
    ArrayList<Passenger> passengers;

    Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    boolean addPassenger(Passenger p) {
        if (passengers.size() < capacity) {
            passengers.add(p);
            return true;
        }
        return false;
    }

    void displayPassengers() {
        System.out.println("Bogie: " + bogieId);
        for (Passenger p : passengers) {
            System.out.println(p.name + " - " + p.age);
        }
    }
}

class Train {
    String trainName;
    ArrayList<Bogie> bogies;

    Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    void addBogie(Bogie b) {
        bogies.add(b);
    }

    void addPassengerToBogie(String bogieId, Passenger p) {
        for (Bogie b : bogies) {
            if (b.bogieId.equals(bogieId)) {
                if (!b.addPassenger(p)) {
                    System.out.println("Bogie full: " + bogieId);
                }
                return;
            }
        }
        System.out.println("Bogie not found");
    }

    void displayTrainDetails() {
        System.out.println("Train: " + trainName);
        for (Bogie b : bogies) {
            b.displayPassengers();
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        Train train = new Train("Express 202");

        Bogie b1 = new Bogie("B1", 2);
        Bogie b2 = new Bogie("B2", 3);

        train.addBogie(b1);
        train.addBogie(b2);

        train.addPassengerToBogie("B1", new Passenger("Arun", 25));
        train.addPassengerToBogie("B1", new Passenger("Vijay", 30));
        train.addPassengerToBogie("B1", new Passenger("Kumar", 40));

        train.addPassengerToBogie("B2", new Passenger("Ravi", 28));
        train.addPassengerToBogie("B2", new Passenger("Sita", 22));

        train.displayTrainDetails();
    }
}