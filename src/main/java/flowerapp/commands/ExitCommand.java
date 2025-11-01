package flowerapp.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Програму завершено. Дякуємо за використання!");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Вихід";
    }
}
