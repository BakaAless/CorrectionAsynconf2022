package me.redstom;

import me.redstom.exo1.Exo1;
import me.redstom.exo2.Exo2;
import me.redstom.exo3.Exo3;
import me.redstom.exo4.Exo4;
import me.redstom.exo5.Exo5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel exercice souhaitez-vous exécuter ? ");
            (switch (scanner.nextLine()) {
                case "1" -> new Exo1();
                case "2" -> new Exo2();
                case "3" -> new Exo3();
                case "4" -> new Exo4();
                case "5" -> new Exo5();

                default ->
                  throw new IllegalArgumentException("L'exercice doit être compris dans la liste : {1, 2, 3, 4, 5}");
            }).run();
        } catch (Exception e) {
            System.err.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
    }
}
