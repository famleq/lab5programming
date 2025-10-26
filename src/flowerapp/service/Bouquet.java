package flowerapp.service;

import flowerapp.model.flowers.Flower;
import flowerapp.model.accessories.Accessory;
import java.util.*;

public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void removeFlower(int index) {
        if (index >= 0 && index < flowers.size())
            flowers.remove(index);
        else
            System.out.println("Неправильний індекс!");
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public void removeAccessory(int index) {
        if (index >= 0 && index < accessories.size()) {
            Accessory removed = accessories.remove(index);
            System.out.println("Видалено аксесуар: " + removed);
        } else {
            System.out.println("Невірний індекс аксесуара!");
        }
    }

    public void showAccessoriesOnly() {
        if (accessories.isEmpty()) {
            System.out.println("— Немає аксесуарів у букеті —");
            return;
        }
        for (int i = 0; i < accessories.size(); i++) {
            System.out.println((i + 1) + ". " + accessories.get(i));
        }
    }


    public void sortByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshness).reversed());
    }

    public List<Flower> findByStemLength(double min, double max) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowers)
            if (f.getStemLength() >= min && f.getStemLength() <= max)
                result.add(f);
        return result;
    }

    public double calculateTotalPrice() {
        double sum = 0;
        for (Flower f : flowers) sum += f.getPrice();
        for (Accessory a : accessories) sum += a.getPrice();
        return sum;
    }

    public void showBouquet() {
        System.out.println("\nКвіти у букеті:");
        for (int i = 0; i < flowers.size(); i++)
            System.out.println((i + 1) + ". " + flowers.get(i));
        if (flowers.isEmpty()) System.out.println("— порожньо —");

        System.out.println("\nАксесуари:");
        for (Accessory a : accessories)
            System.out.println("- " + a);
        if (accessories.isEmpty()) System.out.println("— немає аксесуарів —");
    }
}
