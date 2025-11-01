package flowerapp.commands;

import flowerapp.service.Bouquet;
import java.util.Scanner;

public class RemoveAccessoryCommand implements Command {
    private final Bouquet bouquet;
    private final Scanner scanner;

    public RemoveAccessoryCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("\nПоточні аксесуари у букеті:");
        bouquet.showAccessoriesOnly(); // спеціальний метод лише для аксесуарів

        System.out.print("Введіть номер аксесуара для видалення: ");
        int index = scanner.nextInt();
        bouquet.removeAccessory(index - 1);
    }

    @Override
    public String getName() {
        return "Видалити аксесуар з букета";
    }
}
