package flowerapp.commands;

public class RemoveFlowerCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Видалення квітки з букета]");
    }

    @Override
    public String getName() {
        return "Видалити квітку з букета";
    }
}
