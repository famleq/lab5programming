package flowerapp.model.flowers;

public class Tulip extends Flower {
    private String variety;

    public Tulip(String color, double stemLength, int freshness, double price, String variety) {
        super("Тюльпан", color, stemLength, freshness, price);
        this.variety = variety;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + variety + ")";
    }
}
