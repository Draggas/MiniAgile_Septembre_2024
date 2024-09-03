package main.java;

public enum Mob {
    PETIT_DRAGON(50),
    GRIFFON(50),
    ORC(50),
    SERPENT(50),
    GOBLIN(50),
    SLIME((50)),
    SQUELETTE(50),
    DEMON(50);

    private int pv;

    private Mob(int pv) {
        this.pv = pv;
    }

    public int getPv() {return this.pv;}

    public void setPv(int newPv) {this.pv = newPv;}
}
