import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }

        double total = 0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}