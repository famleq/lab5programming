package flowerapp.commands;

import flowerapp.service.Bouquet;

public class CalculatePriceCommand implements Command {
    private Bouquet bouquet;

    public CalculatePriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        System.out.println("Загальна вартість букета: " + bouquet.calculateTotalPrice() + " грн");
    }

    @Override
    public String getName() {
        return "Обчислити вартість букета";
    }
}
