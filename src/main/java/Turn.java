package main.java;

import java.util.ArrayList;

public class Turn {
    private Joueur player;
    private Mob mob;
    public Turn(Joueur player, Mob mob) {
        this.player = player;
        this.mob = mob;
    }

    public Joueur getJoueur() {
        return this.player;
    }

    public Mob getMob() {
        return this.mob;
    }

    public int damageSimpleAttaque(Joueur attaquant, Mob defenseur) {
        if(Math.random()<attaquant.getCategorie().getCritRate()) {
            return (int)(attaquant.getAtk()*attaquant.getCategorie().getCritDamage()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        } else {
            return (int)(attaquant.getAtk()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        }
    }

    public int damageSimpleAttaque(Mob attaquant, Joueur defenseur) {
        if(Math.random()<0.25) {
            return (int)(attaquant.getAtk()*1.5*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        } else {
            return (int)(attaquant.getAtk()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        }
    }


    public int damageSimpleAttaque(EntityInterface attaquant, EntityInterface defenseur) {
        if(Math.random()<0.25) {
            return (int)(attaquant.getAtk()*1.5*((double)defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)(attaquant.getAtk()*((double)defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }




    public void applyEffect(Joueur player, Competence c) {
        player.setPv(player.getPv()+c.getHealing());
        // System.out.println(c.getHealing());
        player.setDef(player.getDef()+c.getArmor());
        // System.out.println(c.getArmor());
        player.setAtk(player.getAtk()+c.getBoost());
        // System.out.println(c.getBoost());
    }
}