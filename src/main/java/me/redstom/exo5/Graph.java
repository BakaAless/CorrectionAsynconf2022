package me.redstom.exo5;

import java.util.*;

public class Graph {

    private final int width, height;
    private final Vertex[][] vertices;
    private final ArrayList<Vertex>[][] adjacencyList;

    public Graph(int width, int height) {
        this.width = width;
        this.height = height;
        this.vertices = new Vertex[width][height];
        this.adjacencyList = new ArrayList[width][height];
    }

    public void addVertex(Vertex u) {
        if (this.vertices[u.x][u.y] == null) {
            this.vertices[u.x][u.y] = u;
            this.adjacencyList[u.x][u.y] = new ArrayList<>();
        }
    }

    public void addEdge(Vertex u, Vertex v) {
        if (u == null || v == null || this.getNeighbours(u) == null || this.getNeighbours(v) == null)
            return;
        this.getNeighbours(u).add(v);
        this.getNeighbours(v).add(u);
    }

    public ArrayList<Vertex> getNeighbours(Vertex u) {
        return this.adjacencyList[u.x][u.y];
    }
    public Vertex getVertex(int x, int y) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height)
            return null;
        return this.vertices[x][y];
    }

    public List<Vertex> bfs(Vertex start, Vertex end) {
        ArrayList<Vertex> result = new ArrayList<>();
        Deque<Vertex> queue = new ArrayDeque<>();
        ArrayList<Vertex> visited = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (visited.contains(current))
                continue;
            if (current.equals(end)) {
                result.add(current);
                break;
            }
            visited.add(current);
            for (Vertex neighbour : this.getNeighbours(current)) {
                if (!visited.contains(neighbour) && !queue.contains(neighbour)) {
                    neighbour.parent = current;
                    queue.add(neighbour);
                }
            }
        }
        while (result.get(result.size() - 1).parent != null) {
            result.add(result.get(result.size() - 1).parent);
        }
        this.reverse(result);
        return result;
    }

    private <T> void reverse(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            T temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }

    public static class Vertex {
        final int x, y;
        Vertex parent;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
