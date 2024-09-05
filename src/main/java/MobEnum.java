

public enum MobEnum {
    DRAGON(0.15,10,10, Monde.MONDE_2, 600, 50, 140, false, 500, new CompetenceMob("Souffle du dragon",170,0,0,10,0,0,0.3)),
    AMOGUS(0.15,10,10, Monde.MONDE_2, 700, 55, 150, false, 520, new CompetenceMob("Renforcement",0,20,0,0,0,0,0.4)),
    ORC(0.15,10,10, Monde.MONDE_0, 210, 20, 40, false, 70, new CompetenceMob("Coup écrasant",60,0,0,0,0,0,0.3)),
    SERPENT(0.15,10,10, Monde.MONDE_1, 250, 35, 80, false, 280, new CompetenceMob("Mue",0,25,-5,0,0,0,0.4)),
    VAMPIRE(0.15,10,10, Monde.MONDE_1, 350, 35, 90, false, 300, new CompetenceMob("Saignée",30,0,0,0,0,70,0.4)),
    SLIME(0.15,10,10, Monde.MONDE_0, 100, 10, 30, false, 50, new CompetenceMob("Gélatine collante",0,0,0,0,10,0,0.2)),
    SQUELETTE(0.15,10,10, Monde.MONDE_3, 1300, 55, 150, false, 1500, new CompetenceMob("Armée des morts",180,0,0,10,0,0,0.5)),
    DEMON(0.15,10,10, Monde.MONDE_3, 1200, 60, 150, false, 1500, new CompetenceMob("Flammes infernales",180,0,0,10,0,120,0.5)),
    SHREK(0.15,10,10, Monde.MONDE_2, 800, 60, 200, true, 1020, new CompetenceMob("Cri effrayant", 150,0,0,0,30,0,0.3)),
    KRAKEN(0.15,10,10, Monde.MONDE_1, 500, 50, 150, true, 520, new CompetenceMob("Tentation des profondeurs", 180,0,0,20,0,0,0.3)),
    BIG_SLIME(0.15,10,10, Monde.MONDE_0, 380, 40, 50, true, 300, new CompetenceMob("Décharge d'acide",100,0,0,10,0,0,0.35)),
    REINE_DE_LA_FOURMILLIERE(0.15,10,10, Monde.MONDE_3, 2000, 85, 200, true, 0, new CompetenceMob("Piège Mortel",300,0,0,0,20,0,0.35)),
    MERUEM(0.15,10,10, Monde.MONDE_4, 3500, 100, 250, true, 0, new CompetenceMob("Force immense",400,30,0,0,0,0,0.2));
    // Attaque de meruem = "Meruem donne un coup de queue, inflige 400 de dégat et augmente son attaque de 30"

    private final double DROP;
    private final int DROPATK;
    private final int DROPDEF;
    private final Monde MONDE;
    private final int PV, DEF, ATK;
    private final boolean BOSS;
    private final int XP;
    private final CompetenceMob competence;

    private MobEnum(double drop, int dropAtk, int dropDef, Monde monde, int pv, int def, int atk, boolean boss, int xp, CompetenceMob comp) {
        this.DROP = drop;
        this.DROPATK = dropAtk;
        this.DROPDEF = dropDef;
        this.MONDE = monde;
        this.PV = pv;
        this.DEF = def;
        this.ATK = atk;
        this.BOSS = boss;
        this.XP = xp;
        this.competence = comp;
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

    public CompetenceMob getCompetence() {
        return this.competence;
    }
}