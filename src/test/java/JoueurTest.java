package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Joueur;
import main.java.Classe;


public class JoueurTest {
    
    private Joueur j1 = new Joueur("Lucas", Classe.ASSASSIN);
    private Joueur j2 = new Joueur("Maxime", 99, 989, 990, null, Classe.BARBARE);
    private Joueur j3 = new Joueur("Kylian", Classe.MAGE);

    @Test
    void testJoueur() {
        j3.addXp(10);
        assertEquals(2, j3.getLevel());
        j3.addXp(999999);
        assertEquals(3, j3.getLevel());
        assertEquals(1, j1.getLevel());
        j2.setXp(2);
        assertEquals(2, j1.getXp());
        assertEquals(990, j2.getXpmax());
        j3.addXp(1);
        assertEquals(99, j3.getLevel());
        assertEquals(0, j3.getXp());
        assertEquals(50, j1.getPv());
        j1.setPv(75);
        assertEquals(75, j1.getPv());
        assertEquals(2, j2.getAtk());
        j2.setAtk(3);
        assertEquals(3, j2.getAtk());
        assertEquals(3, j3.getDef());
        j3.setDef(0);
        assertEquals(0, j3.getDef());
        assertEquals("Baptiste", j3.getNom());
        assertEquals(Classe.MAGE, j3.getCategorie());
        assertNull(j3.getInventory());
    }
}
