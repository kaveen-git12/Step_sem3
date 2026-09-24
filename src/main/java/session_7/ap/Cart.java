public class Cart {
    private final String id;
    private final double[] prices;
    private int itemCount;

    public Cart(String id, int maxItems) {
        this.id = id;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public String getId() {
        return id;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}