package flowerapp.main;

import flowerapp.commands.*;
import flowerapp.service.Bouquet;
import java.util.*;

public class MainApp {
    private final List<Command> commands = new ArrayList<>();

    public MainApp() {
        Scanner scanner = new Scanner(System.in);
        Bouquet bouquet = new Bouquet();

        commands.add(new CreateFlowerCommand(scanner));
        commands.add(new AddFlowerCommand(bouquet, scanner));
        commands.add(new RemoveFlowerCommand(bouquet, scanner));
        commands.add(new AddAccessoryCommand(bouquet, scanner));
        commands.add(new RemoveAccessoryCommand(bouquet, scanner));
        commands.add(new ShowBouquetCommand(bouquet));
        commands.add(new SortByFreshnessCommand(bouquet));
        commands.add(new FindByStemCommand(bouquet, scanner));
        commands.add(new CalculatePriceCommand(bouquet));
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

