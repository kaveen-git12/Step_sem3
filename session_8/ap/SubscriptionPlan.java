import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SubscriptionPlan> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (planType) {
                case "BASIC":
                    subscribers.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        for (SubscriptionPlan subscriber : subscribers) {
            System.out.println(subscriber.getSubscriberName() + ": " + subscriber.calculateRenewalDate());
        }

        sc.close();
    }
}