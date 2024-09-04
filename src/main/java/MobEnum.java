package main.java;

public enum MobEnum {
    DRAGON(0.15,10,10, Monde.MONDE_2, 600, 50, 140, false, 500),
    AMOGUS(0.15,10,10, Monde.MONDE_2, 700, 55, 150, false, 520),
    ORC(0.15,10,10, Monde.MONDE_0, 210, 20, 40, false, 70),
    SERPENT(0.15,10,10, Monde.MONDE_1, 250, 35, 80, false, 280),
    VAMPIRE(0.15,10,10, Monde.MONDE_1, 350, 35, 90, false, 300),
    SLIME(0.15,10,10, Monde.MONDE_0, 100, 10, 30, false, 50),
    SQUELETTE(0.15,10,10, Monde.MONDE_3, 1300, 55, 150, false, 1500),
    DEMON(0.15,10,10, Monde.MONDE_3, 1200, 60, 150, false, 1500),
    SHREK(0.15,10,10, Monde.MONDE_2, 800, 60, 200, true, 1020),
    KRAKEN(0.15,10,10, Monde.MONDE_1, 500, 50, 150, true, 520),
    BIG_SLIME(0.15,10,10, Monde.MONDE_0, 380, 40, 50, true, 300),
    REINE_DE_LA_FOURMILLIERE(0.15,10,10, Monde.MONDE_3, 2000, 85, 200, true, 0);

    private final double DROP;
    private final int DROPATK;
    private final int DROPDEF;
    private final Monde MONDE;
    private final int PV, DEF, ATK;
    private final boolean BOSS;
    private final int XP;

    private MobEnum(double drop, int dropAtk, int dropDef, Monde monde, int pv, int def, int atk, boolean boss, int xp) {
        this.DROP = drop;
        this.DROPATK = dropAtk;
        this.DROPDEF = dropDef;
        this.MONDE = monde;
        this.PV = pv;
        this.DEF = def;
        this.ATK = atk;
        this.BOSS = boss;
        this.XP = xp;
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

    public boolean isBoss() {
        return this.BOSS;
    }

    public int getXP() {
        return this.XP;
    }
}
