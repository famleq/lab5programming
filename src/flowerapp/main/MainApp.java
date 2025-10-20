package flowerapp.main;

import flowerapp.commands.*;
import java.util.*;

public class MainApp {
    private final List<Command> commands = new ArrayList<>();

    public MainApp() {
        commands.add(new CreateFlowerCommand());
        commands.add(new AddFlowerCommand());
        commands.add(new RemoveFlowerCommand());
        commands.add(new SortByFreshnessCommand());
        commands.add(new FindByStemCommand());
        commands.add(new CalculatePriceCommand());
        commands.add(new ExitCommand());
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== МЕНЮ БУКЕТУ ===");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getName());
            }
            System.out.print("Оберіть дію: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Будь ласка, введіть число.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice > 0 && choice <= commands.size()) {
                commands.get(choice - 1).execute();
            } else {
                System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }

    public static void main(String[] args) {
        new MainApp().showMenu();
    }
}
