package Week8Part2;

import java.util.*;

interface Vertex extends Comparable<Vertex> {
    int getId();
}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {
    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v
     *     node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}

class VertexImpl implements Vertex {
    private int id;
    private Set<Vertex> neighbours;

    public VertexImpl(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Node: " + id + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}

class GraphImpl implements Graph {
    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return this.vertices.values();
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}

/**
 * Implements a Depth first traversal of the Graph, starting at the smallest id. It
 * should return nodes at most once. If there is a choice between next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {
    private Graph g;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int graphSize;
    private Vertex v;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.reset();
    }

    public void reset() {
        this.stack = new Stack<>();
        this.colored = new TreeSet<>();
        if (g != null && v != null) {
            graphSize = g.getAllVertices().size();
            this.stack.add(v);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() && graphSize != colored.size();
    }

    @Override
    public Vertex next() {
        if (this.stack.isEmpty() || graphSize == colored.size()) {
            return null;
        }
        Vertex u = stack.pop();
        colored.add(u);
        List<Vertex> neigh = g.getNeighbours(u);
        Collections.reverse(neigh);
        for (Vertex n : neigh) {
            if (!colored.contains(n)) {
                stack.add(n);
            }
        }
        return u;
    }

    @Override
    public void remove() {
        // Can be ignored.
    }
}
