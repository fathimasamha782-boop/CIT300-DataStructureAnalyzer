package dsanalyzer;

import java.util.*;

public class GraphOperations {

    private Map<Integer, List<Integer>> adjacencyList;

    public GraphOperations() {
        adjacencyList = new LinkedHashMap<>();
    }

    // Add a vertex
    public void addVertex(int vertex) {

        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }

        adjacencyList.put(vertex, new ArrayList<>());

        System.out.println("Vertex " + vertex + " added successfully.");
    }

    // Add an edge
    public void addEdge(int source, int destination) {

        if (!adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {

            System.out.println(
                "Error: Both vertices must exist before adding an edge."
            );

            return;
        }

        if (adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return;
        }

        // Undirected graph
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        System.out.println(
            "Edge added between " + source + " and " + destination
        );
    }

    // Display the graph
    public void displayGraph() {

        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph Representation:");

        for (int vertex : adjacencyList.keySet()) {

            System.out.println(
                vertex + " -> " + adjacencyList.get(vertex)
            );
        }
    }

    // Breadth-First Search
    public void bfs(int startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search
    public void dfs(int startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<Integer> visited = new LinkedHashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(startVertex, visited);

        System.out.println();
    }

    private void dfsRecursive(
            int vertex, Set<Integer> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (int neighbour : adjacencyList.get(vertex)) {

            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }
}

