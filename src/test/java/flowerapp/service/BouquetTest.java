package flowerapp.service;

import flowerapp.model.flowers.*;
import flowerapp.model.accessories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BouquetTest {

    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
    }

    @Test
    void testAddAndRemoveFlower() {
        Flower rose = new Rose("червоний", 30, 8, 50, true);
        bouquet.addFlower(rose);

        assertEquals(50, bouquet.calculateTotalPrice(), 0.001);

        bouquet.removeFlower(0);

        assertEquals(0, bouquet.calculateTotalPrice(), 0.001);
    }

    @Test
    void testAddAndRemoveAccessory() {
        Accessory ribbon = new Ribbon("синя", 10);
        bouquet.addAccessory(ribbon);

        assertEquals(10, bouquet.calculateTotalPrice(), 0.001);

        bouquet.removeAccessory(0);

        assertEquals(0, bouquet.calculateTotalPrice(), 0.001);
    }

    @Test
    void testCalculateTotalPrice() {
        bouquet.addFlower(new Rose("червоний", 25, 7, 40, true));
        bouquet.addFlower(new Tulip("жовтий", 20, 9, 30, "Голландія"));
        bouquet.addAccessory(new WrappingPaper("рожевий", 5));

        double total = bouquet.calculateTotalPrice();
        assertEquals(75, total, 0.001);
    }

    @Test
    void testSortByFreshness() {
        Flower rose = new Rose("червоний", 25, 7, 40, true);
        Flower tulip = new Tulip("жовтий", 20, 9, 30, "Голландія");
        bouquet.addFlower(rose);
        bouquet.addFlower(tulip);

        bouquet.sortByFreshness();

        List<Flower> sorted = bouquet.findByStemLength(0, 100);
        assertEquals("жовтий", sorted.get(0).getColor());
    }

    @Test
    void testFindByStemLength() {
        bouquet.addFlower(new Rose("червоний", 25, 7, 40, true));
        bouquet.addFlower(new Tulip("жовтий", 40, 9, 30, "Голландія"));
        bouquet.addFlower(new Chamomile("білий", 15, 6, 20, 12));

        List<Flower> found = bouquet.findByStemLength(20, 30);

        assertEquals(1, found.size());
        assertEquals("червоний", found.get(0).getColor());
    }

    @Test
    void testEmptyBouquetPrice() {
        assertEquals(0, bouquet.calculateTotalPrice(), 0.001);
    }

    @Test
    void testShowAccessoriesOnlyEmptyAndNonEmpty() {
        bouquet.showAccessoriesOnly();

        bouquet.addAccessory(new Ribbon("синя", 10));
        bouquet.showAccessoriesOnly();
    }

    @Test
    void testShowBouquetEmptyAndNonEmpty() {
        bouquet.showBouquet(); // коли пустий

        bouquet.addFlower(new Rose("червоний", 25, 8, 40, true));
        bouquet.addAccessory(new Card("Вітаю!", 15));
        bouquet.showBouquet(); // коли заповнений
    }

    @Test
    void testRemoveInvalidIndexes() {
        bouquet.addFlower(new Tulip("жовтий", 20, 9, 30, "Голландія"));
        bouquet.addAccessory(new WrappingPaper("рожевий", 5));

        bouquet.removeFlower(-1);
        bouquet.removeFlower(10);
        bouquet.removeAccessory(-1);
        bouquet.removeAccessory(5);
    }



}
