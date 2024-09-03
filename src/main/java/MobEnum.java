package main.java;

public enum MobEnum {
    DRAGON(0.15,10,10, Monde.MONDE_2, 600, 100, 140),
    AMOGUS(0.15,10,10, Monde.MONDE_2, 700, 110, 150),
    ORC(0.15,10,10, Monde.MONDE_0, 210, 40, 40),
    SERPENT(0.15,10,10, Monde.MONDE_1, 250, 70, 80),
    VAMPIRE(0.15,10,10, Monde.MONDE_1, 350, 70, 90),
    SLIME(0.15,10,10, Monde.MONDE_0, 100, 20, 30),
    SQUELETTE(0.15,10,10, Monde.MONDE_3, 1300, 110, 150),
    DEMON(0.15,10,10, Monde.MONDE_3, 1200, 120, 150),
    SHREK(0.15,10,10, Monde.MONDE_2, 800, 120, 200, true),
    KRAKEN(0.15,10,10, Monde.MONDE_1, 500, 100, 150, true),
    SLIME_GEANT(0.15,10,10, Monde.MONDE_0, 380, 80, 50, true),
    FOURMI(0.15,10,10, Monde.MONDE_3, 2000, 170, 200, true);

    private final double DROP;
    private final int DROPATK;
    private final int DROPDEF;
    private final Monde MONDE;
    private final int PV, DEF, ATK;
    private final boolean BOSS;

    private MobEnum(double drop, int dropAtk, int dropDef, Monde monde, int pv, int def, int atk, boolean boss) {
        this.DROP = drop;
        this.DROPATK = dropAtk;
        this.DROPDEF = dropDef;
        this.MONDE = monde;
        this.PV = pv;
        this.DEF = def;
        this.ATK = atk;
        this.BOSS = boss;
    }

    private MobEnum(double drop, int dropAtk, int dropDef, Monde monde, int pv, int def, int atk) {
        this(drop, dropAtk,dropDef,monde,pv,def,atk, false);
    }
    
    public int getPV() {
        return PV;
    }

    public int getDEF() {
        return DEF;
    }

    public int getATK() {
        return ATK;
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
    

    public Monde getMonde() {
        return MONDE;
    }
}
