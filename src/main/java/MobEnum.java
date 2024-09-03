package main.java;

public enum MobEnum {
    PETIT_DRAGON("droppetitdragon",10,10),
    GRIFFON("dropgriffon",10,10),
    ORC("droporc",10,10),
    SERPENT("dropserpent",10,10),
    GOBLIN("dropgobelin",10,10),
    SLIME("dropslime",10,10),
    SQUELETTE("dropsquelette",10,10),
    DEMON("dropdemon",10,10),
    GRAND_DRAGON("dropgranddragon",10,10),
    KRAKEN("dropkraken",10,10),
    SLIME_GEANT("dropslimegeant",10,10),
    FOURMI("dropfourmi",10,10);

    private final String DROP;
    private final int DROPATK;
    private final int DROPDEF;

    private MobEnum(String drop, int dropAtk, int dropDef) {
        this.DROP = drop;
        this.DROPATK = dropAtk;
        this.DROPDEF = dropDef;
    }

    public String getDROP() {
        return DROP;
    }

    public int getDROPATK() {
        return DROPATK;
    }

    public int getDROPDEF() {
        return DROPDEF;
    }
}
