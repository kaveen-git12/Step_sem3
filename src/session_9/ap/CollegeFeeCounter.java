
import java.util.*;

abstract class Student {
    String name;
    static final double BUS_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    abstract boolean usesBus();

    double totalFee() {
        return tuition() + (usesBus() ? BUS_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String n) {
        super(n);
    }

    double tuition() { return 40000; }

    boolean usesBus() { return true; }
}

class Hosteller extends Student {
    Hosteller(String n) {
        super(n);
    }

    double tuition() { return 100000; }

    boolean usesBus() { return false; }
}

class Scholar extends Student {
    Scholar(String n) {
        super(n);
    }

    double tuition() { return 20000; }

    boolean usesBus() { return true; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s = null;

            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                case "SCHOLAR": s = new Scholar(name); break;
            }

            if (s != null) {
                double fee = s.totalFee();
                System.out.printf(Locale.US,
                    "%s: %.2f%n", name, fee);
                total += fee;
            }
        }

        System.out.printf(Locale.US,
            "Total Collected: %.2f%n", total);
    }
}
