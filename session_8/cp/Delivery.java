import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
            }
        }

        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}