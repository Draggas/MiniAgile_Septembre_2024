package main.java;

public class Game {

    static GameState state = GameState.CLASSE;

    Map map;
    Case caseActuel;
    Joueur joueur;

    public static void startGame() {
        System.out.println("start");
    }

    public static GameState getState() {
        return state;
    }

    public Joueur getJoueur() {
        return joueur;
    }

}
