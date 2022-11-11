package me.redstom.exo1;

import me.redstom.utils.Runner;

import java.util.*;

public class Exo1 implements Runner {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Exercice 1 : Veuillez entrer le nom des étapes : ");

        List<String> steps = new ArrayList<>();

        String step;
        while(!(step = sc.nextLine()).isEmpty()) {
            steps.add(step);
        }

        if(steps.isEmpty()) {
            System.err.println("Veuillez entrez au minimum un élément !");
            run();
            return;
        }

        String code = code(steps.toArray(String[]::new));
        System.out.println("Le code est : " + code);
    }

    public String code(String... steps) {
        StringBuilder result = new StringBuilder();

        Set<String> initials = new HashSet<>();

        for (String step : steps) {

            StringBuilder initial = new StringBuilder();
            int letterCount = step.length();
            int index = 0;

            do {
                initial.append(step.charAt(index));
                index++;
                letterCount--;
            } while (initials.contains(initial.toString()));

            initials.add(initial.toString());
            result.append(initial).append(letterCount);

        }

        return result.toString();
    }
}
