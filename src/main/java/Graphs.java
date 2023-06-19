import util.CustomQueue;
import util.Graph;

import java.util.*;

public class Graphs {
    public boolean routeBetweenNodes(int v1, int v2, Graph g) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        visited.put(v1, true);
        queue.add(v1);

        while(!queue.isEmpty()) {
            int v = queue.remove();
            if(v == v2) {
                return true;
            }

            for(int vert : g.adjacencyList.get(v)) {
                if(visited.get(vert) == null) {
                    visited.put(vert, true);
                    queue.add(vert);
                }
            }
        }

        return false;
    }
}
