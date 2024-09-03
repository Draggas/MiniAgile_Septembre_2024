package main.java;

public enum Item {

    GeleeResistante(10, 0, 0),
    PeauSlime(0,0,5);

    int PV;
    int ATK;
    int DEF;

    Item(int PV, int ATK, int DEF) {
        this.PV = PV;
        this.ATK = ATK;
        this.DEF = DEF;
    }

}
