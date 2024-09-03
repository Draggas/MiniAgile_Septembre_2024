package main.java;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

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
        sc.close();

        Classe classe = Classe.values()[i];
        System.out.println("Vous avez choisi la classe " + classe.nom);
    }
}
