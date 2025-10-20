package flowerapp.commands;

public class AddFlowerCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Додавання квітки до букета]");
    }

    @Override
    public String getName() {
        return "Додати квітку до букета";
    }
}
