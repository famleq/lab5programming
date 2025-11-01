package flowerapp.commands;

import flowerapp.model.flowers.Flower;
import flowerapp.service.Bouquet;
import java.util.List;
import java.util.Scanner;

public class FindByStemCommand implements Command {
    private Bouquet bouquet;
    private Scanner scanner;

    public FindByStemCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Мінімальна довжина: ");
        double min = scanner.nextDouble();
        System.out.print("Максимальна довжина: ");
        double max = scanner.nextDouble();

        List<Flower> result = bouquet.findByStemLength(min, max);
        System.out.println("\nРезультати пошуку:");
        for (Flower f : result)
            System.out.println("- " + f);
        if (result.isEmpty()) System.out.println("Нічого не знайдено.");
    }

    @Override
    public String getName() {
        return "Знайти квітку за довжиною стебла";
    }
}
