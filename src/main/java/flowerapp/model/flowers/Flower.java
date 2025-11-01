package flowerapp.model.flowers;

public abstract class   Flower {
    private String name;
    private String color;
    private double stemLength;
    private int freshness; // 1-10
    private double price;

    public Flower(String name, String color, double stemLength, int freshness, double price) {
        this.name = name;
        this.color = color;
        this.stemLength = stemLength;
        this.freshness = freshness;
        this.price = price;
    }

    public double getPrice() { return price; }
    public int getFreshness() { return freshness; }
    public double getStemLength() { return stemLength; }

    @Override
    public String toString() {
        return name + " (" + color + ", " + stemLength + "см, свіжість=" + freshness + ", " + price + " грн)";
    }

    public String getColor() {
        return color;
    }
}
