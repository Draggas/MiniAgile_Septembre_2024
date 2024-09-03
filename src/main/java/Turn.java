package main.java;

import java.util.ArrayList;

public class Turn {
    private Joueur player;
    private Mob mob;
    private ArrayList<Competence> effectsQueuePlayer;
    private ArrayList<Competence> effectsQueueMob;

    public int damageCalculator(Joueur attaquant, Mob defenseur, Competence competence) {
        if(Math.random()<attaquant.getCategorie().getCritRate()) {
            return (int)(attaquant.getAtk()*attaquant.getCategorie().getCritDamage()*(defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)(attaquant.getAtk()*(defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }
}