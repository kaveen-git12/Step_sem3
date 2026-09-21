class Employee {
    // Instance fields unique to each employee
    String empName;
    double salary;

    // Static fields shared across all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment count on object creation
    }

    // Static method printing shared company details
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // Create three Employee objects
        Employee e1 = new Employee("Divya", 65000);
        Employee e2 = new Employee("Arjun", 50000);
        Employee e3 = new Employee("Kavya", 55000);

        // Call printCompanyInfo through class name, not instances
        Employee.printCompanyInfo();
    }
}