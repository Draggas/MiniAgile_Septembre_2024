package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UI {

    public static boolean attack;
    public static List<String> logs = new ArrayList<>();

    public Classe categorie;

    public static void update() {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        switch (main.getGame().getState()) {

            case MENU:
                List<String> menuLine = readFile("res/titre");

                for (int i = 0; i < menuLine.size(); i++)
                    System.out.println(menuLine.get(i));

                break;


            case PLAYING:

                List<String> overlayLines = readFile("res/overlay.txt");
                List<String> menuLinesA = readFile("res/overlay_bottomrightA.txt");
                List<String> menuLinesC = readFile("res/overlay_bottomrightC.txt");
                showPlayer(overlayLines);
                if (main.getGame().getMob() != null) {
                    showMob(overlayLines);
                }
                setStats(overlayLines);
                showLogs(overlayLines);
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


    public static void addLogs(String str) {
        logs.add(str);
        if(logs.size() > 22){
            logs.remove(0);
        }
    }

    private static void showLogs(List<String> list) {

        if (logs.size() == 0)
            return;

        for (int i = 0; i < logs.size(); i++) {
            String line = list.get(i);
            list.remove(i);
            line = line.substring(0, 120) + logs.get(i);
            list.add(i, line);

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
        joueur.setCompetences(joueur.getCategorie());
        String line34 = list.get(34);
        list.remove(34);
        line34 = "█   " + joueur.getCategorie().getNom() + line34.substring(4 + String.valueOf(joueur.getCategorie().getNom()).length());
        list.add(34, line34);

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

        String line34b = list.get(34);
        list.remove(34);
        String nomMob = "";
        
        if(mob.isBoss()){
            nomMob = "\u001B[31m" + mob.getNom() + "\u001B[0m";
        } else {
            nomMob = mob.getNom();
        }
        line34b = line34b.substring(0, 90) + nomMob
                + line34b.substring(90 + String.valueOf(mob.getNom()).length());
        list.add(34, line34b);

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

    public static String getXPBar(int level, int xp) {
        StringBuilder sb = new StringBuilder();
        int xpLevel = 10;
        for (int i=0; i<level; i++) {
            xpLevel *= 1.5;
        }
        for (int i=0; i<7; i++) {
            sb.append(" ");
        }
        sb.append(xp + "\n");
        sb.append("0 [");
        int tailleBarre = (int) (((double) xp / xpLevel) * 10);
        for (int i=0; i<tailleBarre; i++) {
            sb.append("■");
        }
        for (int i=0; i<10-tailleBarre; i++) {
            sb.append(" ");
        }
        sb.append("] " + xpLevel + "\n");
        return sb.toString();
    }
}
