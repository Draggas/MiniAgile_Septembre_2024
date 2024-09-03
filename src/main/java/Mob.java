package main.java;

public enum Mob {
    PETIT_DRAGON(50),
    GRIFFON(50),
    ORC(50),
    SERPENT(50),
    GOBLIN(50),
    SLIME((50));

    private int pv;

    private Mob(int pv) {
        this.pv = pv;
    }
}
