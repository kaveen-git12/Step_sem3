
import java.util.*;

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }
}

interface Insurable {
    double insurance();
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return 0.02 * value;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return 0.02 * value;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();

            Parcel p = null;

            switch (type) {
                case "STANDARD": p = new Standard(w, v); break;
                case "EXPRESS": p = new Express(w, v); break;
                case "FRAGILE": p = new Fragile(w, v); break;
            }

            if (p != null) {
                double c = p.charge();
                double ins = p instanceof Insurable
                        ? ((Insurable) p).insurance() : 0;

                double total = c + ins;
                grandTotal += total;

                System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, c, ins, total);
            }
        }

        System.out.printf(Locale.US,
            "Grand Total: %.2f%n", grandTotal);
    }
}
