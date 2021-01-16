package Week8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {
    private Graph g;
    private Vertex current;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int gone;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        stack = new Stack<>();
        stack.push(v);
        colored = new HashSet<>();
        gone = 0;
    }

    @Override
    public boolean hasNext() {
        return gone != g.getAllVertices().size();
    }

    @Override
    public Vertex next() {
        if(stack.isEmpty()) throw new IllegalArgumentException();

        current = stack.pop();
        if(colored.contains(current)) return next();

        stack.addAll(current.getNeighbours().stream()
                .sorted(Comparator.comparing(Vertex::getId).reversed())
                .collect(Collectors.toList()));
        colored.add(current);
        gone++;

        return current;
    }
}

