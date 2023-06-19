import org.junit.jupiter.api.Test;
import util.Graph;

import static org.junit.jupiter.api.Assertions.*;

class GraphsTest {
    @Test
    public void routeBetweenNodesTest() {
        Graphs graphProblems = new Graphs();
        Graph g1 = new Graph();
        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addVertex(4);
        g1.addVertex(5);
        g1.addVertex(6);
        g1.addEdge(1, 2, true);
        g1.addEdge(2, 5, true);
        g1.addEdge(5, 3, true);
        g1.addEdge(3, 6, true);
        g1.addEdge(6, 4, true);

        assertTrue(graphProblems.routeBetweenNodes(1, 4, g1));

        g1.removeEdge(6, 4, true);

        assertFalse(graphProblems.routeBetweenNodes(1, 4, g1));
    }
}