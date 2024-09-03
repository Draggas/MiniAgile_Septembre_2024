package main.java;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException{

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
        do{
          System.out.print("Merci de choisir un nombre entre 1 et 3 : ");
          try{
            i = sc.nextInt(); 
            badNumber = false;
          }
          catch(Exception e){
            sc.next();
            badNumber = true;
          }
        }while(badNumber || i < 1 || i > 3);
        Classe classe = Classe.values()[i];
        System.out.println("Vous avez choisi la classe " + classe.nom);
        Joueur joueur = new Joueur(Tools.readUser(), classe);
        Map map = new Map();
        Case caseActuel = map.getFirstCase();
        for(int y = 0; y<map.getSizeMap()-1; y++){
          System.out.println(caseActuel);
          Mob mob = caseActuel.mobEncountered();
          System.out.println("Vous rencontrez un " + mob);
          Tools.printEntity(mob.getType());
          Thread.sleep(1000);
          System.out.println("Vous avez battu le monstre, vous passez au prochain");
          caseActuel = map.getRight(caseActuel);
        }
      
    }
}