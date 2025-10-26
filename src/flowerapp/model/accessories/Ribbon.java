package flowerapp.model.accessories;

public class Ribbon extends Accessory {
    private String color;

    public Ribbon(String color, double price) {
        super("Стрічка", price);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + color + "]";
    }
}
