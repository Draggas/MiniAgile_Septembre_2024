package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    GameState state = GameState.MENU;

    Map map;
    Case caseActuel;
    Joueur joueur;
    Mob mob;
    Turn turn;
    boolean cheatCodeImmortel = false;
    boolean cheatCodeOneShot = false;

    public Game() {

        this.joueur = new Joueur();
    }

    public void initGame() {

        for(int i = 0; i < 30; i ++){
            UI.addLogs("               ");
        }


        setState(GameState.MENU);
        UI.update();
        map = new Map();
        caseActuel = map.getFirstCase();
    }

    public void startGame() {
        setState(GameState.PLAYING);

        System.out.println("start");
        newMob();
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Mob getMob() {
        return mob;
    }

    public void newMob() {
        mob = this.caseActuel.mobEncountered();
        UI.update();
        turn = new Turn(joueur, mob);
    }

    public void attackPlayer() {

        int dmg = turn.damageSimpleAttaque(joueur, mob);

        UI.addLogs(joueur.getCategorie().getNom() + " ⚔ " + dmg + " ❤ " + mob.getNom());

        mob.setPv(mob.getPv() - dmg);
        if (mob.getPv() <= 0) { // MORT DU MOB

            UI.addLogs("");
            UI.addLogs(joueur.getCategorie().getNom() + " a tué " + mob.getNom() + " ☠");
            UI.addLogs("");

            

            this.caseActuel = this.map.getRight(this.caseActuel);
            if(!cheatCodeImmortel && !cheatCodeOneShot){
                joueur.resetBuff();
            }
            newMob();
        }
    }

    public void cheatAttackPlayer() {
        cheatCodeOneShot = true;
        joueur.setAtk(999999);
    }
    public void cheatCapacityPlayer() {
        cheatCodeImmortel = true;
        joueur.setDef(999999);
        joueur.setPv(999999);
    }

    public String propositions(ArrayList<Competence> li) {
        String retour = "[";
        for(int i = 0; i<li.size();i++) {
            retour += li.get(i).toString() + "(" + (i+1) + "), ";
        }
        return retour.substring(0, retour.length()-2) + "]";
    }

    public int ask() {
        Scanner scanner = new Scanner(System.in);
        int retour = 0;
        while (retour <1 || retour > 3) {
            System.out.print("Entrez le numéro correspondant à la compétences que vous voulez utiliser : ");
            retour = scanner.nextInt();
        }
        return retour;
    }

    public void capacityPlayer() {
        Turn t = new Turn(joueur, mob);
        System.out.println(propositions(joueur.getCompetences()));
        int bonne_prop = ask();
        // System.out.println(clearSpace(capa));
        
        t.applyEffect(joueur, joueur.getCompetences().get(bonne_prop-1));
        // scanner.nextLine();
    }

    public void attackMob() {
        int degat = turn.damageSimpleAttaque(mob, joueur);
        System.out.println(this.mob.nom + " inflige " + degat + " dégats");
        joueur.setPv(joueur.getPv() - degat);
        if (joueur.getPv() <= 0) {
            // GAME OVER
        }
    }

}
