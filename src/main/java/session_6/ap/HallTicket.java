class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor to set fields
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Create initial HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable pointing to the same object
        HallTicket copy = priya;

        // Modify state through the second variable
        copy.seatNumber = 45;

        // Create a third, separate object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print outputs matching the required format
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}