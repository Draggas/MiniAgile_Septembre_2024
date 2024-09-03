package main.java;

import java.util.ArrayList;

public class Case {
    private Monde numMonde;
    private int numCase;
    private ArrayList<Mob> mobs = new ArrayList<Mob>();

    private final double probaSpawn = 0.75;

    public Case(Monde numMonde, int numCase) {
        this.numMonde = numMonde;
        this.numCase = numCase;
    }

    public void getMobs() {
        for (Mob mob:Mob.values()) {
            if(mob.getWorld() == this.numMonde) {
                this.mobs.add(mob);
            }
        }
    }

    public boolean encounter() {
        return Math.random()<0.75;
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

