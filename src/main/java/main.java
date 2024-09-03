package main.java;

import java.util.Scanner;

public class main {

  static Map map = new Map();
  static Case caseActuel;

  public static void main(String[] args) throws InterruptedException {

    System.out.print("\033[H\033[2J");  
    System.out.flush();  

    System.out.printf("Choississez votre classe :");
    System.out.printf("\n1 : %s (%d d'attaque, %d de défense, %d points de vies", Classe.ASSASSIN.nom,
        Classe.ASSASSIN.atk, Classe.ASSASSIN.def, Classe.ASSASSIN.pv);
    System.out.printf("\n2 : %s (%d d'attaque, %d de défense, %d points de vies", Classe.BARBARE.nom,
        Classe.BARBARE.atk, Classe.BARBARE.def, Classe.BARBARE.pv);
    System.out.printf("\n3 : %s (%d d'attaque, %d de défense, %d points de vies\n", Classe.MAGE.nom, Classe.MAGE.atk,
        Classe.MAGE.def, Classe.MAGE.pv);

    int i = 0;
    boolean badNumber;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("Merci de choisir un nombre entre 1 et 3 : ");
      try {
        i = sc.nextInt();
        badNumber = false;
      } catch (Exception e) {
        sc.next();
        badNumber = true;
      }
    } while (badNumber || i < 1 || i > 3);

    Classe classe = Classe.values()[i - 1];
    System.out.println("Vous avez choisi la classe " + classe.nom);

    Joueur joueur = new Joueur(Tools.readUser(), classe);

    UI.start(joueur);
    caseActuel = map.getFirstCase();
    newMob();

  }

  public static void newMob() {

    Mob mob = caseActuel.mobEncountered();
    UI.mob = mob;
    UI.update();
    System.out.println("Vous rencontrez un " + mob);

  }

}