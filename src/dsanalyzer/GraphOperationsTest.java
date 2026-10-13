package dsanalyzer;

public class GraphOperationsTest {

    public static void main(String[] args) {

        GraphOperations graph = new GraphOperations();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // Display graph
        graph.displayGraph();

        // Perform BFS
        graph.bfs(1);

        // Perform DFS
        graph.dfs(1);
    }
}
