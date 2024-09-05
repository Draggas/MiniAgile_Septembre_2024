import java.io.IOException;
import java.util.Scanner;

public class LegendOfWar {

  static Map map = new Map();
  static Case caseActuel;

  static Game game;


  public static void main(String[] args) throws InterruptedException, IOException {
    System.out.println("Voulez vous reprendre une partie ? (oui / appuyez sur une touche)");

    Scanner sc = new Scanner(System.in);
    String reponse = sc.nextLine();
    sc.close();

    if (reponse.equals("oui")) {
      try {
        game = new Game(true);
      } catch (Exception e) {
        System.out.println("Aucune partie sauvegardée");
      }
    } else {
        game = new Game(false);
    }
    System.out.print("\033[H\033[2J");  
    System.out.flush();  

    game.initGame();
    Keyboard.initKeyboard();


  }


  public static Game getGame() {
      return game;
  }
  

}