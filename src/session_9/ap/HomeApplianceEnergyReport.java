
import java.util.*;

abstract class Appliance {
    double hours;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

interface SaverMode {
    double saverUnits();
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double power() { return 1500; }

    public double saverUnits() {
        return units() * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double power() { return 500; }

    public double saverUnits() {
        return units() * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = sc.hasNext("SAVER") ? sc.next() : "";

            Appliance a = null;

            switch (type) {
                case "FRIDGE": a = new Fridge(hours); break;
                case "AC": a = new AC(hours); break;
                case "TV": a = new TV(hours); break;
                case "WASHER": a = new Washer(hours); break;
            }

            if (a == null) continue;

            if (mode.equals("SAVER") && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units();

            if (mode.equals("SAVER")) {
                units = ((SaverMode) a).saverUnits();
            }

            double cost = units * 8;
            total += cost;

            System.out.printf(Locale.US,
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost);
        }

        System.out.printf(Locale.US,
            "Total Cost: %.2f%n", total);
    }
}
