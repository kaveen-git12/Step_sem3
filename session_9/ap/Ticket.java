import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getBasePricePerTicket();

    public double calculateTotalAmount() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket = null;
            switch (seatType) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            if (ticket != null) {
                double amount = ticket.calculateTotalAmount();
                grandTotal += amount;
                System.out.printf("%s: %.2f%n", seatType, amount);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}