package flowerapp.commands;

public class SortByFreshnessCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Сортування квітів за свіжістю]");
    }

    @Override
    public String getName() {
        return "Сортувати квіти за свіжістю";
    }
}
