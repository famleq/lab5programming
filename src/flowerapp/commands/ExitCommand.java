package flowerapp.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Вихід із програми...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Вихід";
    }
}
