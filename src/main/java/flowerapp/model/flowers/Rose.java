package flowerapp.model.flowers;

public class Rose extends Flower {
    private boolean hasThorns;

    public Rose(String color, double stemLength, int freshness, double price, boolean hasThorns) {
        super("Троянда", color, stemLength, freshness, price);
        this.hasThorns = hasThorns;
    }

    @Override
    public String toString() {
        return super.toString() + (hasThorns ? " [з колючками]" : " [без колючок]");
    }
}
