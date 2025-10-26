package flowerapp.commands;

import flowerapp.model.accessories.*;
import flowerapp.service.Bouquet;
import java.util.Scanner;

public class AddAccessoryCommand implements Command {
    private final Bouquet bouquet;
    private final Scanner scanner;

    public AddAccessoryCommand(Bouquet bouquet, Scanner scanner) {
        this.bouquet = bouquet;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("\nОберіть тип аксесуара:");
        System.out.println("1 - Стрічка");
        System.out.println("2 - Папір для пакування");
        System.out.println("3 - Листівка");
        System.out.print("Ваш вибір: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Accessory accessory = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Колір стрічки: ");
                String color = scanner.nextLine();
                System.out.print("Ціна: ");
                double price = scanner.nextDouble();
                accessory = new Ribbon(color, price);
            }
            case 2 -> {
                System.out.print("Матеріал паперу: ");
                String material = scanner.nextLine();
                System.out.print("Ціна: ");
                double price = scanner.nextDouble();
                accessory = new WrappingPaper(material, price);
            }
            case 3 -> {
                System.out.print("Текст листівки: ");
                String message = scanner.nextLine();
                System.out.print("Ціна: ");
                double price = scanner.nextDouble();
                accessory = new Card(message, price);
            }
            default -> System.out.println("Невірний вибір аксесуара.");
        }

        if (accessory != null) {
            bouquet.addAccessory(accessory);
            System.out.println("Аксесуар додано до букета:");
            System.out.println("   " + accessory);
        }
    }

    @Override
    public String getName() {
        return "Додати аксесуар до букета";
    }
}
