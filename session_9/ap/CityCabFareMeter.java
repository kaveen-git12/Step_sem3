import java.util.Scanner;

interface NightServiceable {
    default double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();

    public double calculateFare(boolean isNight) throws UnsupportedOperationException {
        if (isNight && !(this instanceof NightServiceable)) {
            throw new UnsupportedOperationException("night service not available");
        }

        double fare = km * getRatePerKm();
        if (fare < 100.0) {
            fare = 100.0; // Minimum fare rule
        }

        if (isNight && this instanceof NightServiceable) {
            fare = ((NightServiceable) this).applyNightSurcharge(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = time.equalsIgnoreCase("NIGHT");

            Cab cab = null;
            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
            }

            if (cab != null) {
                try {
                    double fare = cab.calculateFare(isNight);
                    grandTotal += fare;
                    System.out.printf("%s: %.2f\n", cabType.toUpperCase(), fare);
                } catch (UnsupportedOperationException e) {
                    System.out.printf("%s: %s\n", cabType.toUpperCase(), e.getMessage());
                }
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}