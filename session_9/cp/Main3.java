import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class ElectricityConnection {
    protected double units;
    protected String type;

    public ElectricityConnection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        double totalBilled = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            ElectricityConnection conn = null;

            switch (type.toUpperCase()) {
                case "HOME":
                    conn = new HomeConnection(units);
                    break;
                case "SHOP":
                    conn = new ShopConnection(units);
                    break;
                case "FACTORY":
                    conn = new FactoryConnection(units);
                    break;
            }

            if (conn != null) {
                connections.add(conn);
            }
        }

        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            totalBilled += bill;
            System.out.printf("%s: %.2f\n", conn.getType(), bill);
        }

        System.out.printf("Total: %.2f\n", totalBilled);
        scanner.close();
    }
}