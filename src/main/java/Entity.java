package main.java;

interface Entity {

    int pv, atk, def;
    String nom;

    abstract public int getPv();

    abstract public void setPv(int pv);

    abstract public int getAtk();

    abstract public void setAtk(int atk);

    abstract public int getDef();

    abstract public void setDef(int def);

    abstract public String getNom();

    abstract public void setNom(String nom);

}