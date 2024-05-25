import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();
        for (int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 5, 2);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 9);
        graph.addEdge(3, 4, 7);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 0, 1);
        graph.addEdge(5, 4, 8);
        graph.addEdge(5, 2, 1);

        System.out.println("Vertices:");
        for (Integer v : graph.getVertices()) {
            System.out.println("Vertex: " + v);
        }

        System.out.println("Edges:");
        for (Integer v : graph.getVertices()) {
            Vertex<Integer> vertex = graph.getVertex(v);
            for (Map.Entry<Vertex<Integer>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
                System.out.println("Edge: " + v + " -> " + entry.getKey().getData() + " with weight " + entry.getValue());
            }
        }

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(graph, 0);
        System.out.println("BFS path from 0 to 4:");
        System.out.println(bfs.pathTo(4));

        DijkstraSearch<Integer> dijkstra = new DijkstraSearch<>(graph, 0);
        System.out.println("Dijkstra path from 0 to 4:");
        System.out.println(dijkstra.pathTo(4));
    }
}
