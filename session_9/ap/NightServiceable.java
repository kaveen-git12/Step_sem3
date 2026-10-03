import java.util.Scanner;

interface NightServiceable {
    double getNightSurchargeRate();
}

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.0;

    public abstract double getRatePerKm();

    public double calculateFare(double distanceKm, String timeOfDay) {
        double baseFare = distanceKm * getRatePerKm();
        if ("NIGHT".equalsIgnoreCase(timeOfDay) && this instanceof NightServiceable) {
            baseFare += baseFare * ((NightServiceable) this).getNightSurchargeRate();
        }
        return Math.max(baseFare, MINIMUM_FARE);
    }
}

class MiniCab extends Cab {
    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double getNightSurchargeRate() {
        return 0.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double getNightSurchargeRate() {
        return 0.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            switch (cabType) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SUVCab();
                    break;
            }

            if (cab != null) {
                if ("NIGHT".equalsIgnoreCase(time) && !(cab instanceof NightServiceable)) {
                    System.out.printf("%s: night service not available%n", cabType);
                } else {
                    double fare = cab.calculateFare(km, time);
                    totalCollected += fare;
                    System.out.printf("%s: %.2f%n", cabType, fare);
                }
            }
        }

        System.out.printf("Total: %.2f%n", totalCollected);
        scanner.close();
    }
}