package flowerapp.commands;

public class FindByStemCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Пошук квітки за довжиною стебла]");
    }

    @Override
    public String getName() {
        return "Знайти квітку за довжиною стебла";
    }
}
