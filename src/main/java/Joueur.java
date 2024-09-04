package main.java;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Entity {
    private int level;
    private int xp;
    private int xpmax;
    private List<Item> inventory = new ArrayList<Item>();
    private Classe categorie;

    public Joueur(String nom, int level, int xp, int xpmax, List<Item> inventory, Classe categorie){
        this.nom = nom;
        this.level = level;
        this.xp = xp;
        this.xpmax = xpmax;
        this.inventory = inventory;
        this.categorie = categorie;
        if (categorie == Classe.ASSASSIN){
            this.pv = 100;
            this.atk = 40;
            this.def = 30;
        } else if(categorie == Classe.BARBARE){
            this.pv = 200;
            this.atk = 70;
            this.def = 60;
        } else {
            this.pv = 150;
            this.atk = 110;
            this.def = 20;
        }
    }

    public Joueur(String nom, Classe categorie){
        this(nom, 1, 0, 10, null, categorie);
    }

    public void addXp(int valeur){
        xp = xp + valeur;
        if(xp >= xpmax){
            if(level == 30){
                xp = xpmax - 1;
            } else {
                lvlUp();
            }

        }
    }

    private void lvlUp(){
        xp = 0;
        level++;
        xpmax *= 1.1;
        pv += 20;
        def += 5;
        atk += 10;
    }

    public boolean addInventory(Item object){
        return inventory.add(object);
    }

    public boolean removeInventory(Item object){
        return inventory.remove(object);
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getXpmax() {
        return xpmax;
    }

    public List<Item> getInventory() {
        return inventory;
    }
    public int getPv() {
        return this.pv;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }



    public String getNom() {
        return this.nom;
    }

    public Classe getCategorie() {
        return categorie;
    }

    public void setCategorie(Classe categorie) {
        this.categorie = categorie;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
