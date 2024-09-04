package test.java;

import main.java.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TurnTest {
    private Joueur player = new Joueur("Banana", Classe.ASSASSIN);
    private Mob mob = new Mob(MobEnum.DRAGON);
    private Turn turn = new Turn(player, mob);

    @Test
    void testTurn() {
        player.getCategorie().setCritRate(0);
        assertEquals(20,turn.damageSimpleAttaque(player, mob));
        
    }
}
