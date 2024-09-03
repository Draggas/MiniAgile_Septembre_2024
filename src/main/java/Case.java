package main.java;

import java.util.ArrayList;

public class Case {
    private Monde monde;
    private int numCase;
    private ArrayList<Mob> mobs = new ArrayList<Mob>();


    public Case(Monde monde, int numCase) {
        this.monde = monde;
        this.numCase = numCase;
        this.setMobs();
    }

    public String toString(){
        return "Monde : " + this.monde + "   Niveau : " + this.numCase;
    }

    public void setMobs() {
        for (MobEnum mob:MobEnum.values()) {
            if(mob.getMonde() == this.monde) {
                this.mobs.add(new Mob(null, numCase, numCase, numCase));
            }
        }
    }

    public Monde getmonde() {
        return this.monde;
    }

    public int getNumCase() {
        return this.numCase;
    }

    public Mob mobEncountered() {
        if(Math.random()<0.5) {
            return this.mobs.get(0);
        } else {
            return this.mobs.get(1);
        }
    }

    public Mob encounterBoss() {
        return this.mobs.get(3);
    }
}

