package main.java;

public class Game {

    GameState state = GameState.CLASSE;

    Map map;
    Case caseActuel;
    Joueur joueur;

    public Game() {
        this.joueur = new Joueur("", Classe.ASSASSIN);
    }

    public  void initGame() {
        System.out.println("start");
    }

    public  void startGame() {
        System.out.println("start");
    }

    public GameState getState() {
        return state;
    }

    public Joueur getJoueur() {
        return joueur;
    }

}
