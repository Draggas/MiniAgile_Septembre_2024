
public enum MobEnum {

    SLIME(0.15, 10, 10, Monde.MONDE_0, 100, 30, 30, false, 50,
            new CompetenceMob("Gélaine collante", 0, 0, 0, 10, 0, 0, 0.2)),
    ORC(0.15, 10, 10, Monde.MONDE_0, 210, 40, 40, false, 70,
            new CompetenceMob("Coup écrasant", 60, 0, 0, 0, 0, 0, 0.15)),
    BIG_SLIME(0.15, 10, 10, Monde.MONDE_0, 380, 60, 50, true, 300,
            new CompetenceMob("Décharge d'acide", 100, 0, 0, 10, 0, 0, 0.2)),
    SERPENT(0.15, 10, 10, Monde.MONDE_1, 250, 55, 80, false, 280, new CompetenceMob("Mue", 0, 25, -5, 0, 0, 0, 0.2)),
    VAMPIRE(0.15, 10, 10, Monde.MONDE_1, 350, 55, 90, false, 300, new CompetenceMob("Saignée", 30, 0, 0, 0, 0, 0, 70)),
    KRAKEN(0.15, 10, 10, Monde.MONDE_1, 500, 70, 150, true, 520,
            new CompetenceMob("Tentation des profondeurs", 180, 0, 0, 20, 0, 0, 0)),
    DRAGON(0.15, 10, 10, Monde.MONDE_2, 600, 70, 140, false, 500,
            new CompetenceMob("Souffle du dragon", 170, 0, 0, 10, 0, 0, 0.2)),
    AMOGUS(0.15, 10, 10, Monde.MONDE_2, 700, 75, 150, false, 520,
            new CompetenceMob("Renforcement", 0, 20, 0, 0, 0, 0, 0.3)),
    SHREK(0.15, 10, 10, Monde.MONDE_2, 800, 80, 200, true, 1020,
            new CompetenceMob("Cri effrayant", 150, 0, 0, 0, 30, 0, 0.2)),
    DEMON(0.15, 10, 10, Monde.MONDE_3, 1200, 80, 150, false, 1500,
            new CompetenceMob("Flammes infernales", 180, 0, 0, 10, 0, 120, 0.35)),
    SQUELETTE(0.15, 10, 10, Monde.MONDE_3, 1300, 75, 150, false, 1500,
            new CompetenceMob("Armée des morts", 180, 0, 0, 10, 0, 0, 0.4)),
    REINE_DE_LA_FOURMILLIERE(0.15, 10, 10, Monde.MONDE_3, 2000, 100, 200, true, 0,
            new CompetenceMob("Piège Mortel", 300, 0, 0, 0, 20, 0, 0.1));

    private final double DROP;
    private final int DROPATK;
    private final int DROPDEF;
    private final Monde MONDE;
    private final int PV, DEF, ATK;
    private final boolean BOSS;
    private final int XP;
    private final CompetenceMob competence;
    private final Item LOOT;

    private MobEnum(double drop, int dropAtk, int dropDef, Monde monde, int pv, int def, int atk, boolean boss, int xp,
            CompetenceMob comp) {
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
        double rdm = Math.random();
        int valeur = 0;
        if (rdm > 0.5) {
            valeur = 1;
        }
        this.LOOT = Item.values()[this.ordinal() * 2 + valeur];
        if (this.LOOT == null) {
            System.exit(-1);
        }
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

    public Item getLOOT() {
        return LOOT;
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