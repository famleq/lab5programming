package flowerapp.model.accessories;

public class Card extends Accessory {
    private String message;

    public Card(String message, double price) {
        super("Листівка", price);
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + message + "]";
    }
}
