package flowerapp.service;

import flowerapp.model.flowers.Flower;
import flowerapp.model.accessories.Accessory;
import java.util.*;
import static flowerapp.service.LoggerManager.*;

public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
        logInfo("Додано квітку: " + flower);
    }

    public void removeFlower(int index) {
        if (index >= 0 && index < flowers.size()) {
            Flower removed = flowers.remove(index);
            logInfo("Видалено квітку: " + removed);
        } else {
            logWarning("Спроба видалити квітку за неправильним індексом: " + index);
        }
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
        logInfo("Додано аксесуар: " + accessory);
    }

    public void removeAccessory(int index) {
        if (index >= 0 && index < accessories.size()) {
            Accessory removed = accessories.remove(index);
            logInfo("Видалено аксесуар: " + removed);
        } else {
            logWarning("Спроба видалити аксесуар за неправильним індексом: " + index);
        }
    }

    public void showAccessoriesOnly() {
        if (accessories.isEmpty()) {
            logInfo("Користувач переглянув аксесуари: порожній список");
            System.out.println("— Немає аксесуарів у букеті —");
            return;
        }

        logInfo("Користувач переглянув список аксесуарів (" + accessories.size() + ")");
        for (int i = 0; i < accessories.size(); i++)
            System.out.println((i + 1) + ". " + accessories.get(i));
    }

    public void sortByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshness).reversed());
        logInfo("Виконано сортування квітів за свіжістю");
    }

    public List<Flower> findByStemLength(double min, double max) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowers)
            if (f.getStemLength() >= min && f.getStemLength() <= max)
                result.add(f);

        logInfo("Виконано пошук квітів за довжиною стебла: [" + min + ", " + max + "], знайдено " + result.size());
        return result;
    }

    public double calculateTotalPrice() {
        try {
            double sum = 0;
            for (Flower f : flowers) sum += f.getPrice();
            for (Accessory a : accessories) sum += a.getPrice();

            logInfo("Розраховано загальну ціну букета: " + sum);
            return sum;
        } catch (Exception e) {
            logError("Помилка при розрахунку вартості букета", e);
            return 0;
        }
    }

    public void showBouquet() {
        System.out.println("\nКвіти у букеті:");
        for (int i = 0; i < flowers.size(); i++)
            System.out.println((i + 1) + ". " + flowers.get(i));
        if (flowers.isEmpty())
            System.out.println("— порожньо —");

        System.out.println("\nАксесуари:");
        for (Accessory a : accessories)
            System.out.println("- " + a);
        if (accessories.isEmpty())
            System.out.println("— немає аксесуарів —");

        logInfo("Користувач переглянув повний вміст букета");
    }
}
