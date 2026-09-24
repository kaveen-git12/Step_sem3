public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getHealth() {
        return currentHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHealth = Math.max(0, currentHealth - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            currentHealth = Math.min(maxHealth, currentHealth + amount);
        }
    }
}