package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void addVertex(int val) {
        adjacencyList.putIfAbsent(val, new ArrayList<>());
    }

    public void removeVertex(int val) {
        adjacencyList.values().forEach(e -> e.remove(val));
        adjacencyList.remove(val);
    }

    /*
    Creates an edge from val1 -> val2
    */
    public void addEdge(int val1, int val2, boolean directed) {

        if(adjacencyList.get(val1) != null) adjacencyList.get(val1).add(val2);
        if(!directed) {
            if(adjacencyList.get(val2) != null) adjacencyList.get(val2).add(val1);
        }
    }

    /*
    Removes the edge from val1 -> val2
     */
    public void removeEdge(int val1, int val2, boolean directed) {


        List<Integer> v1edge = adjacencyList.get(val1);

        if(v1edge != null) {
            v1edge.removeIf(e -> e == val2);
        }

        if(!directed) {
            List<Integer> v2edge = adjacencyList.get(val2);

            if(v2edge != null) {
                v2edge.remove(val1);
            }
        }
    }

}
