
import java.util.*;

abstract class Connection {
    double units;

    Connection(double u) {
        units = u;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(double u) {
        super(u);
    }

    double bill() {
        return Math.min(units, 100) * 5
             + Math.max(0, units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double u) {
        super(u);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double u) {
        super(u);
    }

    double bill() {
        return Math.max(1000, units * 6);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Connection c = null;

            switch (type) {
                case "HOME":
                    c = new Home(units);
                    break;
                case "SHOP":
                    c = new Shop(units);
                    break;
                case "FACTORY":
                    c = new Factory(units);
                    break;
            }

            if (c != null) {
                double b = c.bill();
                System.out.printf(Locale.US, "%s: %.2f%n", type, b);
                total += b;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
