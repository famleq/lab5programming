package flowerapp.commands;

public class CalculatePriceCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[Обчислення вартості букета]");
    }

    @Override
    public String getName() {
        return "Обчислити вартість букета";
    }
}
