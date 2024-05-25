import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
    }

    @Override
    protected void bfs() {
        distTo = new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        pq.add(new VertexDistance<>(start, 0.0));
        distTo.put(start, 0.0);
        marked.put(start, true);

        while (!pq.isEmpty()) {
            VertexDistance<V> current = pq.poll();
            V v = current.getVertex();
            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(v).getAdjacentVertices().entrySet()) {
                V w = entry.getKey().getData();
                double weight = entry.getValue();
                double newDist = distTo.get(v) + weight;
                if (!distTo.containsKey(w) || newDist < distTo.get(w)) {
                    distTo.put(w, newDist);
                    edgeTo.put(w, v);
                    pq.add(new VertexDistance<>(w, newDist));
                    marked.put(w, true);
                }
            }
        }
    }

    private static class VertexDistance<V> {
        private V vertex;
        private double distance;

        public VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public V getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
