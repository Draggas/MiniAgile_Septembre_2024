package main.java;

public enum MobEnum {
    DRAGON(0.15,10,10),
    AMOGUS(0.15,10,10),
    ORC(0.15,10,10),
    SERPENT(0.15,10,10),
    DIO(0.15,10,10),
    SLIME(0.15,10,10),
    SQUELETTE(0.15,10,10),
    DEMON(0.15,10,10),
    SHREK(0.15,10,10),
    KRAKEN(0.15,10,10),
    SLIME_GEANT(0.15,10,10),
    FOURMI(0.15,10,10);

    private final double DROP;
    private final int DROPATK;
    private final int DROPDEF;

    private MobEnum(double drop, int dropAtk, int dropDef) {
        this.DROP = drop;
        this.DROPATK = dropAtk;
        this.DROPDEF = dropDef;
    }

    public double getDROP() {
        return DROP;
    }

    public int getDROPATK() {
        return DROPATK;
    }

    public int getDROPDEF() {
        return DROPDEF;
    }
}
