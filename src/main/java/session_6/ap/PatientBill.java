class PatientBill {
    String patientName;
    double consultationFee;
    double labCharges;

    // Constructor to initialize all fields
    public PatientBill(String patientName, double consultationFee, double labCharges) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
        this.labCharges = labCharges;
    }

    // Instance method to compute total bill
    public double getTotalBill() {
        return consultationFee + labCharges;
    }

    // Method to display patient details and total bill
    public void displayBill() {
        System.out.println("Patient: " + patientName + " | Total Bill: ₹" + getTotalBill());
    }

    public static void main(String[] args) {
        // Create an array of PatientBill objects
        PatientBill[] bills = new PatientBill[] {
            new PatientBill("Ramesh", 500.0, 1200.0),
            new PatientBill("Suresh", 300.0, 450.0),
            new PatientBill("Priya", 700.0, 2500.0)
        };

        // Process array using a loop
        for (PatientBill bill : bills) {
            bill.displayBill();
        }
    }
}