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

public class UI implements NativeKeyListener {

    static Joueur joueur;
    static boolean attack;
    static Mob mob;

    public static void start(Joueur j) {

        joueur = j;

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new UI());

        update();

    }

    public static void update() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        List<String> overlayLines = readFile("res/overlay.txt");
        List<String> menuLinesA = readFile("res/overlay_bottomrightA.txt");
        List<String> menuLinesC = readFile("res/overlay_bottomrightC.txt");

        showPlayer(overlayLines);

        if (mob != null) {
            showMob(overlayLines);
        }

        setStats(overlayLines);

        for (int i = 0; i < overlayLines.size(); i++) {
            if (i > 22) {
                System.out.println(overlayLines.get(i) + (attack ? menuLinesA.get(i - 22) : menuLinesC.get(i - 22)));
            } else {
                System.out.println(overlayLines.get(i));
            }
        }

    }

    public void nativeKeyReleased(NativeKeyEvent e) {


        if (e.getKeyCode() == 57416 || e.getKeyCode() == 57424) { // arrow up
            attack = !attack;
        }

        if (e.getKeyCode() == 28) { // enter
            main.caseActuel = main.map.getRight(main.caseActuel);
            main.newMob();

        }

        update();

    }

    private static void showMob(List<String> list) {

        List<String> listmage = readFile("res/ascii/" + mob.getNom());
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = line.substring(0, 50) + listmage.get(i - 2) + line.substring(50 + listmage.get(i - 2).length());
            list.add(i, line);
        }

    }

    private static void showPlayer(List<String> list) {
        List<String> listmage = readFile("res/ascii/" + joueur.getCategorie().toString() + ".txt");
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = "█ " + listmage.get(i - 2) + line.substring(listmage.get(i - 2).length() + 2);
            list.add(i, line);
        }

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
