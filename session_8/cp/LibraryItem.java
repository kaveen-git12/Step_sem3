import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate();
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            // Read title handling quoted strings
            String title = sc.findInLine("\".*?\"|\\S+").replace("\"", "");

            switch (type) {
                case "BOOK":
                    items.add(new Book(title));
                    break;
                case "DVD":
                    items.add(new DVD(title));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title));
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}