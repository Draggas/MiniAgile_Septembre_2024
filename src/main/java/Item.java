package main.java;

public enum Item {
    SLIME_GR("Gelée Résistante",3,10),
    SLIME_PS("Peau Slime",2,5),
    ORC_BO("Bracelet Orc",2,10),
    ORC_AF("Anneau De Force",1,10),
    SLIMEGEANT_EF("Essence De Force",1,20),
    SLIMEGEANT_CS("Couronne De Slime",3,10),
    SERPENT_EM("Ecaille Mineur",2,10),
    SERPENT_PS("Poison Du Serpent",5,10),
    VAMPIRE_AV("Anneau De Vitalité",3,20),
    VAMPIRE_CV("Cape De Vampire",4,20),
    KRAKEN_FT("Fragment De Tentacule",5,15),
    KRAKEN_FK("Force De Kraken",1,30),
    DRAGON_GD("Griffe De Dragon",1,25),
    DRAGON_ED("Ecaille De Dragon",2,20),
    AMOGUS_CS("Casque De Survie",4,10),
    AMOGUS_GI("Gants D'Imposteur",1,20),
    SHREK_CS("Chaussure De Shrek",4,10),
    SHREK_ES("Epée de Shrek",1,40),
    DEMON_GD("Gant Du Démon",1,40),
    DEMON_CD("Corne Du Démon",5,10),
    SQUELETTE_EO("Epée En Os",1,35),
    SQUELETTE_BS("Bouclier Du Squelette",2,50);

    private String name;
    private int stat; // 1 = Atk, 2 = Def, 3 = PV, 4 = Esquive, 5 = Coup critique
    private int bonus;

    Item(String name, int stat, int bonus) {
        this.name = name;
        this.stat = stat;
        this.bonus = bonus;
    }
    public String getName() {
        return name;
    }
    public int getStat() {
        return stat;
    }
    public int getBonus() {
        return bonus;
    }
}
