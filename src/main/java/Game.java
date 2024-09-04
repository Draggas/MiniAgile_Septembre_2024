package main.java;

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

    public String clearSpace(String s) {
        String retour = "";
        for(int i = 0; i<s.length();i++) {
            if(s.charAt(i) != ' ') {
                retour += s.charAt(i);
            }
        }
        return retour;
    }

    public void capacityPlayer() {
        Scanner scanner = new Scanner(System.in);
        Turn t = new Turn(joueur, mob);
        System.out.println(joueur.getCompetences().toString());
        String capa = scanner.nextLine();
        // System.out.println(clearSpace(capa));
        
        t.applyEffect(joueur, Competence.valueOf(clearSpace(capa)));
        // scanner.nextLine();
    }

    public void attackMob() {
        joueur.setPv(joueur.getPv() - turn.damageSimpleAttaque(mob, joueur));
        if (joueur.getPv() <= 0) {
            // GAME OVER
        }
    }

}
