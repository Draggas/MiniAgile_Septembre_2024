package main.java;

public class Game {

    GameState state = GameState.CLASSE;

    Map map;
    Case caseActuel;
    Joueur joueur;
    Mob mob;

    public Game() {
        this.joueur = new Joueur("", Classe.ASSASSIN);
    }

    public  void initGame() {
        setState(GameState.CLASSE);
        UI.start(joueur);
        map = new Map();
        caseActuel = map.getFirstCase();
    }

    public  void startGame() {
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
    
    }

    public void attack(){
        mob.setPv(mob.getPv() - joueur.getAtk());
        if(mob.getPv() <= 0){
            this.caseActuel = this.map.getRight(this.caseActuel);
            newMob();
        }
    }

    public void capacity() {
        mob.setPv(mob.getPv() - joueur.getAtk()*10);
        if(mob.getPv() <= 0){
            this.caseActuel = this.map.getRight(this.caseActuel);
            newMob();
        }
    }
    

}
