package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    static Joueur joueur;
    static boolean attack;

    public static void main(String[] args) {

        joueur = new Joueur("Player", Classe.MAGE);

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        List<String> overlayLines = readFile("res/overlay.txt");
        List<String> menuLinesA = readFile("res/overlay_bottomrightA.txt");
        List<String> menuLinesC = readFile("res/overlay_bottomrightC.txt");



        setStats(overlayLines);

        for (int i = 0; i < overlayLines.size(); i++) {
            if (i > 22) {
                System.out.println(overlayLines.get(i) + (attack ? menuLinesA.get(i-22) : menuLinesC.get(i-22)));
            } else {
                System.out.println(overlayLines.get(i));
            }
        }

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

    }

    private static void setStats(List<String> list) {

        String line35 = list.get(35);
        list.remove(35);
        line35 = "█   ❤ : " + joueur.getPv() + line35.substring(8 + String.valueOf(joueur.getPv()).length());
        list.add(35, line35);

        String line36 = list.get(36);
        list.remove(36);
        line36 = "█   ⚔ : " + joueur.getAtk() + line36.substring(8 + String.valueOf(joueur.getAtk()).length());
        list.add(36, line36);

        String line37 = list.get(37);
        list.remove(37);
        line37 = "█   ⛨ : " + joueur.getDef() + line37.substring(8 + String.valueOf(joueur.getDef()).length());
        list.add(37, line37);

    }

    public static List<String> readFile(String path) {

        List<String> lines = new ArrayList<>();

        try (FileReader fr = new FileReader(path)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }

}
