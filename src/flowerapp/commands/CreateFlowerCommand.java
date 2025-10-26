package flowerapp.commands;

import flowerapp.model.flowers.*;
import java.util.Scanner;

public class CreateFlowerCommand implements Command {
    private final Scanner scanner;

    public CreateFlowerCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Оберіть тип квітки: 1-Троянда, 2-Тюльпан, 3-Ромашка");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Колір: ");
        String color = scanner.nextLine();

        System.out.print("Довжина стебла (см): ");
        double length = scanner.nextDouble();

        System.out.print("Свіжість (1-10): ");
        int fresh = scanner.nextInt();

        System.out.print("Ціна: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Flower flower = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Чи є колючки (true/false): ");
                boolean thorns = scanner.nextBoolean();
                flower = new Rose(color, length, fresh, price, thorns);
            }
            case 2 -> {
                scanner.nextLine();
                System.out.print("Сорт тюльпана: ");
                String variety = scanner.nextLine();
                flower = new Tulip(color, length, fresh, price, variety);
            }
            case 3 -> {
                System.out.print("Кількість пелюсток: ");
                int petals = scanner.nextInt();
                flower = new Chamomile(color, length, fresh, price, petals);
            }
            default -> System.out.println("Невірний вибір.");
        }

        if (flower != null) {
            System.out.println("\nСтворена квітка:");
            System.out.println(flower);
        }
    }

    @Override
    public String getName() {
        return "Створити окрему квітку (перегляд)";
    }
}
