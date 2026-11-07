
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String n, double s) {
        super(n);
        salary = s;
    }

    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String n, double h, double r) {
        super(n);
        hours = h;
        rate = r;
    }

    double pay() {
        return hours <= 40
                ? hours * rate
                : 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String n, double s) {
        super(n);
        stipend = s;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s = null;

            switch (type) {
                case "FULLTIME":
                    s = new FullTime(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    s = new Hourly(name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    s = new Intern(name, sc.nextDouble());
                    break;
            }

            if (s != null) {
                double p = s.pay();
                System.out.printf(Locale.US, "%s: %.2f%n", name, p);
                total += p;
            }
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
