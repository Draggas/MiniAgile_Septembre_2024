package main.java;

public class Game {

    GameState state = GameState.MENU;

    Map map;
    Case caseActuel;
    Joueur joueur;
    Mob mob;
    Turn turn;

    public Game() {
        this.joueur = new Joueur("", Classe.ASSASSIN);
    }

    public void initGame() {
        setState(GameState.MENU);
        UI.update();
        map = new Map();
        caseActuel = map.getFirstCase();


        for(int i = 0; i < 30; i ++){
            UI.addLogs("               ");
        }

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
        mob.setPv(mob.getPv() - dmg);
        if (mob.getPv() <= 0) { // MORT DU MOB
            UI.addLogs("");
            UI.addLogs(joueur.getNom() + "  ☠  " + mob.getNom());
            UI.addLogs("");
            this.caseActuel = this.map.getRight(this.caseActuel);
            joueur.resetBuff();
            newMob();

        }

        UI.addLogs(joueur.getNom() + " " + dmg +" ⚔ " + mob.getNom() );

    }

    public void cheatAttackPlayer() {
        int dmg = 9999999;
        mob.setPv(mob.getPv() - dmg);
        if (mob.getPv() <= 0) { // MORT DU MOB
            UI.addLogs("");
            UI.addLogs(joueur.getNom() + "  ☠  " + mob.getNom());
            UI.addLogs("");
            this.caseActuel = this.map.getRight(this.caseActuel);
            newMob();
        }

        UI.addLogs(joueur.getNom() + " " + dmg +" ⚔ " + mob.getNom() );

    }

    public void capacityPlayer() {
        Turn t = new Turn(joueur, mob);
        t.applyEffect(joueur, Competence.ARMURE_MAGIQUE);
    }

    public void attackMob() {
        joueur.setPv(joueur.getPv() - turn.damageSimpleAttaque(mob, joueur));
        if (joueur.getPv() <= 0) {
            // GAME OVER
        }
    }
}
