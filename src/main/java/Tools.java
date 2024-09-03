package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Tools {
    public static String readFile(String path) throws Exception {
        File fichier = new File(path);
        Scanner sc = new Scanner(fichier);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(sc.nextLine());
        }
        sc.close();
        return sb.toString();
    }

    public static void writeFile(String path, String content) throws Exception{
        FileWriter fw = new FileWriter(path);
        fw.write(content);
        fw.close();
    }

    public static void printEntity(MobEnum m) {
        try {
            System.out.println(Tools.readFile("res/ascii/"+m.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        String name = sc.nextLine();
        sc.close();
        return name;
    }

    public static void savePlayer(Joueur j) {
        try {
            FileOutputStream fos = new FileOutputStream("res/save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(j);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de sauvegarder la partie");
        }    
    }

    public static void loadPlayer() {
        try {
            FileInputStream fis = new FileInputStream("res/save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Joueur j = (Joueur) ois.readObject();
            ois.close();
            System.out.println("Partie chargée");
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de charger la partie");
        }
    }
}
