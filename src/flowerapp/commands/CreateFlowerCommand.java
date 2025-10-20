package flowerapp.commands;

public class CreateFlowerCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Створення квітки]");
    }

    @Override
    public String getName() {
        return "Створити квітку";
    }
}
