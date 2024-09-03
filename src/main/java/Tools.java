package main.java;

import java.io.File;
import java.io.FileWriter;
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

    public static void main(String[] args) {
        printEntity(MobEnum.SERPENT);
    }
}
