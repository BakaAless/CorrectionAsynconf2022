package me.redstom.exo5;

import me.redstom.utils.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exo5 implements Runner {

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Exercice 5 : Veuillez entrer le plan de la zone : ");

        List<String> lines = new ArrayList<>();

        String step;
        while (!(step = sc.nextLine()).isEmpty()) {
            lines.add(step);
        }

        if (lines.isEmpty()) {
            System.err.println("Veuillez entrez au minimum une ligne !");
            run();
            return;
        }

        System.out.println(this.code(lines));
    }

    public String code(List<String> lines) {
        int width = lines.get(0).length();
        int height = lines.size();
        Graph graph = new Graph(width, height);
        Graph.Vertex start = null, current, end = null;
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < width; x++) {
                current = new Graph.Vertex(x, y);
                if (lines.get(y).charAt(x) == 'O')
                    continue;
                graph.addVertex(current);
                if (lines.get(y).charAt(x) == 'X')
                    start = current;
                if (lines.get(y).charAt(x) == 'V')
                    end = current;
                graph.addEdge(current, graph.getVertex(x, y - 1));
                graph.addEdge(current, graph.getVertex(x - 1, y));
            }
        }

        return String.join(";", graph.bfs(start, end).stream()
                .map(vertex ->
                        ((char) (vertex.x + 65)) + "" + (vertex.y + 1)
                ).toArray(String[]::new)
        );

    }

}
