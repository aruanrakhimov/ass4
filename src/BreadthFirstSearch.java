import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
    }

    @Override
    protected void bfs() {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        marked.put(start, true);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Vertex<V> w : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (!marked.containsKey(w.getData())) {
                    queue.add(w.getData());
                    marked.put(w.getData(), true);
                    edgeTo.put(w.getData(), v);
                }
            }
        }
    }
}
