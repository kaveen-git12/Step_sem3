import java.util.Scanner;

interface SaverModeCapable {
    default double applySaverMode(double originalUnits) {
        return originalUnits * 0.75; // 25% reduction
    }
}

abstract class Appliance {
    protected double powerWatts;

    public Appliance(double powerWatts) {
        this.powerWatts = powerWatts;
    }

    public double calculateUnits(double hours, boolean isSaver) throws UnsupportedOperationException {
        if (isSaver && !(this instanceof SaverModeCapable)) {
            throw new UnsupportedOperationException("saver mode not supported");
        }

        double units = (powerWatts * hours) / 1000.0;
        if (isSaver && this instanceof SaverModeCapable) {
            units = ((SaverModeCapable) this).applySaverMode(units);
        }

        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge() {
        super(150.0);
    }
}

class AirConditioner extends Appliance implements SaverModeCapable {
    public AirConditioner() {
        super(1500.0);
    }
}

class TV extends Appliance {
    public TV() {
        super(100.0);
    }
}

class WashingMachine extends Appliance implements SaverModeCapable {
    public WashingMachine() {
        super(500.0);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] tokens = line.split("\\s+");
            String applianceType = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean isSaver = tokens.length > 2 && tokens[2].equalsIgnoreCase("SAVER");

            Appliance appliance = null;
            switch (applianceType.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new WashingMachine();
                    break;
            }

            if (appliance != null) {
                try {
                    double units = appliance.calculateUnits(hours, isSaver);
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;

                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", applianceType.toUpperCase(), units, cost);
                } catch (UnsupportedOperationException e) {
                    System.out.printf("%s: %s\n", applianceType.toUpperCase(), e.getMessage());
                }
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}