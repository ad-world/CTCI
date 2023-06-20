import util.CustomQueue;
import util.Graph;
import util.TreeNode;

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

    public TreeNode createMinimalBST(int[] array) {
        if(array.length == 0) return null;
        return createMinimalBSTHelper(array, 0, array.length - 1);
    }

    private TreeNode createMinimalBSTHelper(int[] array, int start, int end) {
        if(start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        int target = array[middle];
        TreeNode node = new TreeNode(target);
        node.left = createMinimalBSTHelper(array, start, middle - 1);
        node.right = createMinimalBSTHelper(array, middle + 1, end);
        return node;
    }
}
