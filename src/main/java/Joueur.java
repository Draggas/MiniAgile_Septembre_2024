package main.java;

import java.util.ArrayList;
import java.util.List;

class Joueur {
    private String pseudo;
    private int level;
    private int xp;
    private int xpmax;
    private List<Drop> inventory = new ArrayList<Drop>();
    private Classe categorie;

    public Joueur(String pseudo, int level, int xp, int xpmax, List<Drop> inventory, Classe categorie){
        this.pseudo = pseudo;
        this.level = level;
        this.xp = xp;
        this.inventory = inventory;
        this.categorie = categorie;
    }

    public Joueur(String pseudo, Classe categorie){
        this(pseudo, 1, 0, 10, null, categorie);
    }

    public void verifLevel(){
        if(xp >= xpmax){
            if(level == 99){
                xp = xpmax - 1;
            } else {
                xp = 0;
                level++;
                xpmax = level*10;
            }

        }
    }

    public boolean addInventory(Drop object){
        return inventory.add(object);
    }

    public boolean removeInventory(Drop object){
        return inventory.remove(object);
    }
    
    public String getPseudo() {
        return pseudo;
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

    public List<Drop> getInventory() {
        return inventory;
    }
    public int getPv() {
        return categorie.getPv();
    }

    public int getAtk() {
        return categorie.getAtk();
    }

    public int getDef() {
        return categorie.getDef();
    }

    public String getNom() {
        return categorie.getNom();
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setPv(int pv) {
        categorie.setPv(pv);
    }

    public void setAtk(int atk) {
        categorie.setAtk(atk);
    }

    public void setDef(int def) {
        categorie.setDef(def);
    }
}
