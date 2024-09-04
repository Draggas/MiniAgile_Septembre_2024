package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class UI {

    public static boolean attack;

    public static void start(Joueur j) {       

        update();

    }

    public static void update() {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        switch (main.getGame().getState()) {
            case PLAYING:

                List<String> overlayLines = readFile("res/overlay.txt");
                List<String> menuLinesA = readFile("res/overlay_bottomrightA.txt");
                List<String> menuLinesC = readFile("res/overlay_bottomrightC.txt");
                showPlayer(overlayLines);
                if (main.getGame().getMob() != null) {
                    showMob(overlayLines);
                }
                setStats(overlayLines);
                for (int i = 0; i < overlayLines.size(); i++) {
                    if (i > 22) {
                        System.out.println(
                                overlayLines.get(i) + (attack ? menuLinesA.get(i - 22) : menuLinesC.get(i - 22)));
                    } else {
                        System.out.println(overlayLines.get(i));
                    }
                }
                break;

            case CLASSE:
                showClasse();
                break;

            default:
                break;
        }

    }

    

    private static void showClasse() {

        List<String> textLines = readFile("res/classchoice.txt");
        List<String> classeLines = readFile("res/classe.txt");
        List<String> arrowLines = readFile("res/arrow.txt");

        for (int i = 0; i < textLines.size(); i++)
            System.out.println(textLines.get(i));

        for (int i = 0; i < classeLines.size(); i++)
            System.out.println(classeLines.get(i));

        switch (main.getGame().getJoueur().getCategorie()) {
            case ASSASSIN:

                String blank = "";
                for (int i = 0; i < 12; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));
                break;
            case BARBARE:
                blank = "";
                for (int i = 0; i < 77; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));

                break;
            case MAGE:
                blank = "";
                for (int i = 0; i < 137; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));
                break;
            default:
                break;
        }

    }

    private static void showMob(List<String> list) {

        List<String> listmage = readFile("res/ascii/" + main.getGame().getMob().getNom());
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = line.substring(0, 50) + listmage.get(i - 2) + line.substring(50 + listmage.get(i - 2).length());
            list.add(i, line);
        }

    }

    private static void showPlayer(List<String> list) {
        List<String> listmage = readFile("res/ascii/" + main.getGame().getJoueur().getCategorie().toString());
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = "█ " + listmage.get(i - 2) + line.substring(listmage.get(i - 2).length() + 2);
            list.add(i, line);
        }

    }

    private static void setStats(List<String> list) {

        Joueur joueur = main.getGame().getJoueur();

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

        Mob mob = main.getGame().getMob();

        String line35b = list.get(35);
        list.remove(35);
        line35b = line35b.substring(0, 90) + "❤ : " + mob.getPv()
                + line35b.substring(94 + String.valueOf(mob.getPv()).length());
        list.add(35, line35b);

        String line36b = list.get(36);
        list.remove(36);
        line36b = line36b.substring(0, 90) + "⚔ : " + mob.getAtk()
                + line36b.substring(94 + String.valueOf(mob.getAtk()).length());
        list.add(36, line36b);

        String line37b = list.get(37);
        list.remove(37);
        line37b = line37b.substring(0, 90) + "⛨ : " + mob.getDef()
                + line37b.substring(94 + String.valueOf(mob.getDef()).length());
        list.add(37, line37b);

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
            System.out.println("Le fichier est introuvable");
        } catch (Exception e) {
            System.out.println("Unknown exception");
        }

        return lines;

    }

}
