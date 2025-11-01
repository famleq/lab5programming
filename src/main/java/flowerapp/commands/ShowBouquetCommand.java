package flowerapp.commands;

import flowerapp.service.Bouquet;

public class ShowBouquetCommand implements Command {
    private final Bouquet bouquet;

    public ShowBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        bouquet.showBouquet();
    }

    @Override
    public String getName() {
        return "Переглянути букет";
    }
}
