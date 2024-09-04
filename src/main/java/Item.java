package main.java;

public enum Item implements EntityInterface{

    GeleeResistante(10, 0, 0),
    PeauSlime(0,0,5);

    int PV;
    int ATK;
    int DEF;
    String name;

    Item(int PV, int ATK, int DEF) {
        this.PV = PV;
        this.ATK = ATK;
        this.DEF = DEF;
    }

    @Override
    public int getPv() {
        return this.PV;
    }

    @Override
    public void setPv(int pv) {
        this.PV = pv;
    }

    @Override
    public int getAtk() {
        return this.ATK;
    }

    @Override
    public void setAtk(int atk) {
        this.ATK = atk;
    }

    @Override
    public int getDef() {
        return this.DEF;
    }

    @Override
    public void setDef(int def) {
        this.DEF = def;
    }

    @Override
    public String getNom() {
        return this.name;
    }

    @Override
    public void setNom(String nom){
        this.name = nom;
    }


}
