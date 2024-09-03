package main.java;

public class Mob extends Entity {
    MobEnum type;

    public Mob(String nom, int pv, int atk, int def) {
        this.nom = type.toString();
        this.pv = pv;
        this.atk = atk;
        this.def = def;
    }

    public MobEnum getType() {
        return type;
    }

    public void setType(MobEnum type) {
        this.type = type;
    }

    public int getPv() {
        return this.pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
