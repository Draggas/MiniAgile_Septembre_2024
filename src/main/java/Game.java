package main.java;

public class Game {

    GameState state = GameState.CLASSE;

    Map map;
    Case caseActuel;
    Joueur joueur;
    Mob mob;
    Turn turn;

    public Game() {
        this.joueur = new Joueur("", Classe.ASSASSIN);
    }

    public void initGame() {
        setState(GameState.CLASSE);
        UI.start(joueur);
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
        turn = new Turn();
    }

    public void attackPlayer() {
        System.out.println(turn.damageSimpleAttaque(joueur, mob));
        mob.setPv(mob.getPv() - turn.damageSimpleAttaque(joueur, mob));
        if (mob.getPv() < 0) { // MORT DU MOB
            this.caseActuel = this.map.getRight(this.caseActuel);
            newMob();
        }
    }

    public void capacityPlayer() {
        mob.setPv(mob.getPv() - turn.damageCompetence(joueur, mob, Competence.SOINS_MAJEURS)); // A changer pour mettre
                                                                                               // la bonne compétence
        if (mob.getPv() < 0) { // MORT DU MOB
            this.caseActuel = this.map.getRight(this.caseActuel);
            newMob();
        }
    }

    public void attackMob() {
        joueur.setPv(joueur.getPv() - turn.damageSimpleAttaque(mob, joueur));
        if (joueur.getPv() < 0) {
            // GAME OVER
        }
    }

}
