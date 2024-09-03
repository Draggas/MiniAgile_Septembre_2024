package main.java;

public enum Boss {
    GRAND_DRAGON(100),
    KRAKEN(100),
    SLIME_GEANT(100),
    FOURMIE(9999);

    private int pv;

    private Boss(int pv) {
        this.pv = pv;
    }

    public int getPv() {return this.pv;}

    public void setPv(int newPv) {this.pv = newPv;}
}
