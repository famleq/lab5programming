package flowerapp.commands;

import flowerapp.service.Bouquet;
import java.util.Scanner;

public class RemoveFlowerCommand implements Command {
    private Bouquet bouquet;
    private Scanner scanner;

    public RemoveFlowerCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        bouquet.showBouquet();
        System.out.print("Введіть номер квітки для видалення: ");
        int index = scanner.nextInt();
        bouquet.removeFlower(index - 1);
    }

    @Override
    public String getName() {
        return "Видалити квітку з букета";
    }
}
