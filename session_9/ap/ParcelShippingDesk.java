import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        // Standard charge + 50 handling fee
        return (40.0 + 10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            Parcel parcel = null;
            if (type.equalsIgnoreCase("STANDARD")) {
                parcel = new StandardParcel(weight, value);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcel = new ExpressParcel(weight, value);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcel = new FragileParcel(weight, value);
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).calculateInsurance() : 0.0;
                double total = charge + insurance;
                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", 
                                  type.toUpperCase(), charge, insurance, total);
            }
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}