package flowerapp.model.accessories;

public class WrappingPaper extends Accessory {
    private String material;

    public WrappingPaper(String material, double price) {
        super("Папір для пакування", price);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + material + "]";
    }
}
