package test.java;

import main.java.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TurnTest {
    private Turn turn = new Turn();
    private Joueur player = new Joueur("Banana", Classe.ASSASSIN);
    private Mob mob = new Mob(MobEnum.DRAGON);

    @Test
    void testTurn() {
        assertEquals(20,turn.damageSimpleAttaque(player, mob));
        assertEquals(32,turn.damageSimpleAttaque(mob, player));
        assertEquals(40,turn.damageCompetence(player, mob, Competence.ATTAQUE_RENFORCEE));
        assertEquals(41, turn.damageCompetence(mob, player, Competence.ATTAQUE_RENFORCEE));

        
    }
}
