package flowerapp.model;

import flowerapp.model.flowers.*;
import flowerapp.model.accessories.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerModelTest {

    @Test
    void testRose() {
        Rose rose = new Rose("червоний", 25, 8, 40, true);
        assertNotNull(rose);
        assertTrue(rose.toString().contains("червоний"));
        assertTrue(rose.toString().contains("40"));
    }

    @Test
    void testTulip() {
        Tulip tulip = new Tulip("жовтий", 20, 9, 30, "Голландія");
        assertNotNull(tulip);
        assertTrue(tulip.toString().contains("Голландія"));
        assertTrue(tulip.toString().contains("30"));
    }

    @Test
    void testChamomile() {
        Chamomile chamomile = new Chamomile("білий", 15, 6, 20, 12);
        assertNotNull(chamomile);
        assertTrue(chamomile.toString().contains("білий"));
        assertTrue(chamomile.toString().contains("12"));
    }

    @Test
    void testRibbon() {
        Ribbon ribbon = new Ribbon("синя", 10);
        assertNotNull(ribbon);
        assertTrue(ribbon.toString().contains("10"));
    }

    @Test
    void testWrappingPaper() {
        WrappingPaper paper = new WrappingPaper("рожевий", 5);
        assertNotNull(paper);
        assertTrue(paper.toString().contains("рожевий"));
    }

    @Test
    void testCard() {
        Card card = new Card("З любов’ю", 15);
        assertNotNull(card);
        assertTrue(card.toString().contains("З любов’ю"));
    }
}
