
package dsanalyzer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/** Undirected graph using an adjacency list, with BFS and DFS traversal. */
public class GraphOperations {

    // vertex -> list of neighbours (adjacency list)
    private final Map<Integer, List<Integer>> adj = new TreeMap<>();

    // step counters for the Performance Comparison
    private long lastBfsSteps = 0;
    private long lastDfsSteps = 0;

    public long getLastBfsSteps() { return lastBfsSteps; }
    public long getLastDfsSteps() { return lastDfsSteps; }
    public boolean isEmpty()      { return adj.isEmpty(); }

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(int v) {
        if (adj.containsKey(v)) return false;
        adj.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns an error message, or null if OK. */
    public String addEdge(int a, int b) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) return "Both vertices must exist first.";
        if (a == b) return "Self-loops are not allowed.";
        if (adj.get(a).contains(b)) return "That edge already exists.";
        adj.get(a).add(b);
        adj.get(b).add(a);
        return null;
    }

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency list:");
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Breadth-first search using a queue. O(V + E). */
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastBfsSteps = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            lastBfsSteps++;                 // visit a vertex
            order.add(v);
            for (int n : adj.get(v)) {
                lastBfsSteps++;             // check an edge
                if (visited.add(n)) queue.add(n);
            }
        }
        return order;
    }

    /** Depth-first search using recursion (call stack). O(V + E). */
    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastDfsSteps = 0;
        dfsVisit(start, new HashSet<>(), order);
        return order;
    }

    private void dfsVisit(int v, Set<Integer> visited, List<Integer> order) {
        visited.add(v);
        lastDfsSteps++;                     // visit a vertex
        order.add(v);
        for (int n : adj.get(v)) {
            lastDfsSteps++;                 // check an edge
            if (!visited.contains(n)) dfsVisit(n, visited, order);
        }
    }

    // ---------------- Menu ----------------
    public void runMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int v = readInt(sc, "Enter vertex number: ");
                    System.out.println(addVertex(v) ? "Vertex " + v + " added." : "Vertex already exists.");
                    break;
                case 2:
                    int a = readInt(sc, "Enter first vertex: ");
                    int b = readInt(sc, "Enter second vertex: ");
                    String err = addEdge(a, b);
                    System.out.println(err == null ? "Edge " + a + " - " + b + " added." : "ERROR: " + err);
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    if (adj.isEmpty()) { System.out.println("Graph is empty. Add vertices first."); break; }
                    int s1 = readInt(sc, "Enter start vertex: ");
                    if (!adj.containsKey(s1)) { System.out.println("Start vertex not found."); break; }
                    System.out.println("BFS: " + bfs(s1) + "  (steps: " + lastBfsSteps + ")");
                    break;
                case 5:
                    if (adj.isEmpty()) { System.out.println("Graph is empty. Add vertices first."); break; }
                    int s2 = readInt(sc, "Enter start vertex: ");
                    if (!adj.containsKey(s2)) { System.out.println("Start vertex not found."); break; }
                    System.out.println("DFS: " + dfs(s2) + "  (steps: " + lastDfsSteps + ")");
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-6.");
            }
        } while (choice != 6);
    }

    // Keeps asking until the user enters a whole number
    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}

