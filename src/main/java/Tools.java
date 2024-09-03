package main.java;

import java.io.File;
import java.util.Scanner;

public class Tools {
    public static String readFile(String path) throws Exception {
        File fichier = new File(path);
        Scanner sc = new Scanner(fichier);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        sc.close();
        return sb.toString();
    }
}
