package flowerapp.model.flowers;

public class Chamomile extends Flower {
    private int petalsCount;

    public Chamomile(String color, double stemLength, int freshness, double price, int petalsCount) {
        super("Ромашка", color, stemLength, freshness, price);
        this.petalsCount = petalsCount;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + petalsCount + " пелюсток]";
    }
}
