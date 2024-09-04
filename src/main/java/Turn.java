package main.java;

import java.util.ArrayList;

public class Turn {
    private Joueur player;
    private Mob mob;
    private ArrayList<Competence> effectsQueuePlayer;
    private ArrayList<Competence> effectsQueueMob;

    public int damageSimpleAttaque(Joueur attaquant, Mob defenseur) {
        if(Math.random()<attaquant.getCategorie().getCritRate()) {
            return (int)(attaquant.getAtk()*attaquant.getCategorie().getCritDamage()*(defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)(attaquant.getAtk()*(defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }

    public int damageSimpleAttaque(Mob attaquant, Joueur defenseur) {
        if(Math.random()<0.25) {
            return (int)(attaquant.getAtk()*1.5*(defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)(attaquant.getAtk()*(defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }

    public int damageCompetence(Joueur attaquant, Mob defenseur, Competence competence) {
        if(Math.random()<attaquant.getCategorie().getCritRate()) {
            return (int)((attaquant.getAtk() + competence.getDamage())*attaquant.getCategorie().getCritDamage()*(defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)((attaquant.getAtk() + competence.getDamage())*(defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }

    public int damageCompetence(Mob attaquant, Joueur defenseur, Competence competence) {
        if(Math.random()<0.25) {
            return (int)((attaquant.getAtk() + competence.getDamage())*1.5*(defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)((attaquant.getAtk() + competence.getDamage())*(defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }

    public void competenceBuffer(Competence competence, Joueur player) {
        this.effectsQueuePlayer.add(competence);
    }

    public void competenceBuffer(Competence competence, Mob mob) {
        this.effectsQueueMob.add(competence);
    }

    public void applyCompetenceBufferEffects(Mob mob) {
        for(int i = 0; i<this.effectsQueueMob.size();i++) {
            Competence capa = this.effectsQueueMob.get(i);
            int maxTurn = 0;
            for(Competence c:Competence.values()) {
                if(c.toString().equals(capa.toString())) {
                    maxTurn = c.getTurn();
                }
            }
            if(capa.getDamage()!=0 && capa.getTurn() != maxTurn) {
                this.mob.setPv(damageCompetence(player, mob, capa));
            }
            if(capa.getHealing()!=0 && capa.getTurn() != maxTurn) {
                this.mob.setPv(this.mob.getPv()+capa.getHealing());
            }
            capa.turnPast();
            if(capa.getTurn() == 0) {
                this.mob.setDef(this.mob.getDef()-capa.getArmor());
            }
        }
        for(int i = 0; i<this.effectsQueueMob.size();i++) {
            if(this.effectsQueueMob.get(i).getTurn()==0) {
                this.effectsQueueMob.remove(i);
            }
        }
    }

    public void applyCompetenceBufferEffects(Joueur player) {
        for(int i = 0; i<this.effectsQueuePlayer.size();i++) {
            Competence capa = this.effectsQueuePlayer.get(i);
            int maxTurn = 0;
            for(Competence c:Competence.values()) {
                if(c.toString().equals(capa.toString())) {
                    maxTurn = c.getTurn();
                }
            }
            if(capa.getDamage()!=0 && capa.getTurn() != maxTurn) {
                this.player.setPv(damageCompetence(mob, player, capa));
            }
            if(capa.getHealing()!=0 && capa.getTurn() != maxTurn) {
                this.player.setPv(this.player.getPv()+capa.getHealing());
            }
            capa.turnPast();
            if(capa.getTurn() == 0) {
                this.player.setDef(this.player.getDef()-capa.getArmor());
                this.player.getCategorie().setCritRate(0.25);
            }
        }
        for(int i = 0; i<this.effectsQueueMob.size();i++) {
            if(this.effectsQueueMob.get(i).getTurn()==0) {
                this.effectsQueueMob.remove(i);
            }
        }
    }

}