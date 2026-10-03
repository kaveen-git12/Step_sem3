import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
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
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalBilled = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();

            ElectricityConnection conn = null;
            if (type.equals("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                conn = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                conn = new FactoryConnection(units);
            }

            if (conn != null) {
                double bill = conn.calculateBill();
                totalBilled += bill;
                System.out.printf("%s: %.2f%n", type, bill);
            }
        }

        System.out.printf("Total: %.2f%n", totalBilled);
        scanner.close();
    }
}