package main.java;

import java.util.ArrayList;
import java.util.List;

class Joueur {
    String pseudo;
    int level;
    int xp;
    int xpmax;
    List<Drop> inventory = new ArrayList<Drop>();
    Classe categorie;

    Joueur(String pseudo, int level, int xp, int xpmax, List<Drop> inventory, Classe categorie){
        this.pseudo = pseudo;
        this.level = level;
        this.xp = xp;
        this.inventory = inventory;
        this.categorie = categorie;
    }

    Joueur(String pseudo, Classe categorie){
        this(pseudo, 1, 0, 10, null, categorie);
    }

    void verifLevel(){
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
}
