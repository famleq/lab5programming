package flowerapp.commands;

import flowerapp.model.flowers.*;
import flowerapp.service.Bouquet;
import java.util.Scanner;

public class AddFlowerCommand implements Command {
    private final Bouquet bouquet;
    private final Scanner scanner;

    public AddFlowerCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("\nОберіть тип квітки:");
        System.out.println("1 - Троянда");
        System.out.println("2 - Тюльпан");
        System.out.println("3 - Ромашка");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Колір: ");
        String color = scanner.nextLine();

        System.out.print("Довжина стебла (см): ");
        double stemLength = scanner.nextDouble();

        System.out.print("Свіжість (1-10): ");
        int freshness = scanner.nextInt();

        System.out.print("Ціна (грн): ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Flower flower = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Чи є колючки? (true/false): ");
                boolean hasThorns = scanner.nextBoolean();
                flower = new Rose(color, stemLength, freshness, price, hasThorns);
            }
            case 2 -> {
                scanner.nextLine();
                System.out.print("Сорт тюльпана: ");
                String variety = scanner.nextLine();
                flower = new Tulip(color, stemLength, freshness, price, variety);
            }
            case 3 -> {
                System.out.print("Кількість пелюсток: ");
                int petalsCount = scanner.nextInt();
                flower = new Chamomile(color, stemLength, freshness, price, petalsCount);
            }
            default -> System.out.println("Невірний вибір типу квітки.");
        }

        if (flower != null) {
            bouquet.addFlower(flower);
            System.out.println("Квітку додано до букета:");
            System.out.println("   " + flower);
        }
    }

    @Override
    public String getName() {
        return "Додати квітку до букета";
    }
}
