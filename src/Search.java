import java.util.*;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected V start;
    protected Map<V, Boolean> marked;
    protected Map<V, V> edgeTo;

    public Search(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        this.start = start;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
        bfs();
    }

    protected abstract void bfs();

    public boolean hasPathTo(V v) {
        return marked.containsKey(v);
    }

    public List<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
