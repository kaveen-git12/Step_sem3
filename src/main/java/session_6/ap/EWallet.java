class EWallet {
    private double balance;

    // Constructor with validation
    public EWallet(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Error: Initial balance cannot be negative. Setting balance to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Add funds with positive value validation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be greater than 0.");
            return;
        }
        this.balance += amount;
        System.out.println("Deposit successful. New Balance: ₹" + this.balance);
    }

    // Withdraw funds with sufficiency check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Transaction rejected: Insufficient funds.");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdrawal successful. Remaining Balance: ₹" + this.balance);
    }

    // Read-only getter
    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        EWallet wallet = new EWallet(1000.0);
        wallet.deposit(500.0);
        wallet.withdraw(2000.0); // Rejection test
        wallet.withdraw(800.0);
        System.out.println("Final Wallet Balance: ₹" + wallet.getBalance());
    }
}