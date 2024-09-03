package main.java;

public enum Classe  {
    ASSASSIN(50,4,1,"l'assassin"),
    BARBARE(150,2,2,"le barbare"),
    MAGE(100,2,3,"le grand mage");

    public int pv;
    public int atk;
    public int def;
    public String nom;

    Classe(int pv, int atk, int def, String nom){
        this.pv = pv;
        this.atk = atk;
        this.def = def;
        this.nom = nom;
    }
}
