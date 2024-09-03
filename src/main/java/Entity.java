package main.java;

abstract class Entity {

    int pv, atk, def;
    String nom;

    private Entity(String nom, int pv,int atk,int def){
        this.nom = nom;
        this.pv = pv;
        this.atk = atk;
        this.def = def;
    }

}