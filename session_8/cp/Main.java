import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Capped at $10
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private final double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            List<Transport> journeys = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double distance = sc.nextDouble();

                switch (type) {
                    case "BUS" -> journeys.add(new Bus(distance));
                    case "TRAIN" -> journeys.add(new Train(distance));
                    case "METRO" -> {
                        double factor = sc.nextDouble();
                        journeys.add(new Metro(distance, factor));
                    }
                    default -> {
                    }
                }
            }

            double total = 0;
            for (Transport t : journeys) {
                double fare = t.calculateFare();
                System.out.printf("%s: %.2f%n", t.getType(), fare);
                total += fare;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}