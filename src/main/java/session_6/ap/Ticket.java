class Ticket {
    String passengerName;
    String source;
    String destination;
    double price;

    // Full 4-argument constructor
    public Ticket(String passengerName, String source, String destination, double price) {
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // Overloaded constructor chaining default source "Chennai"
    public Ticket(String passengerName, String destination, double price) {
        this(passengerName, "Chennai", destination, price);
    }

    public void displayDetails() {
        System.out.println("Passenger: " + passengerName + " | Route: " + source + " -> " + destination + " | Fare: ₹" + price);
    }

    public static void main(String[] args) {
        Ticket t1 = new Ticket("Anish", "Coimbatore", 450.0); // Uses chained constructor
        Ticket t2 = new Ticket("Bhavana", "Bangalore", "Hyderabad", 1200.0);

        t1.displayDetails();
        t2.displayDetails();
    }
}