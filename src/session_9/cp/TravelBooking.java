
import java.util.*;

abstract class Booking {
    static final double FEE = 50;
    double distance;

    Booking(double d) {
        distance = d;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Booking {
    Bus(double d) {
        super(d);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double d) {
        super(d);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double d) {
        super(d);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking b = null;

            switch (mode) {
                case "BUS":
                    b = new Bus(distance);
                    break;
                case "TRAIN":
                    b = new Train(distance);
                    break;
                case "FLIGHT":
                    b = new Flight(distance);
                    break;
            }

            if (b != null) {
                double amount = b.total();
                System.out.printf(Locale.US, "%s: %.2f%n", mode, amount);
                total += amount;
            }
        }
    }
}
