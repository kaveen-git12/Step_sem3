class IdCard {
    String name;
    int booksIssued;

    // Constructor to initialize fields
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Create initial IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Point a second reference variable to the same object
        IdCard duplicate = ravi;

        // Modify state through the second reference
        duplicate.booksIssued = 3;

        // Create a third, separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);

        // Verification outputs
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}