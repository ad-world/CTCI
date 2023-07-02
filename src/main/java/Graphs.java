import com.sun.source.tree.Tree;
import util.CustomQueue;
import util.Graph;
import util.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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

    public List<LinkedList<Integer>> listOfDepths(TreeNode root) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        listOfDepthsHelper(root, map, 0);

        return new ArrayList<>(map.values());
    }

    private void listOfDepthsHelper(TreeNode root, HashMap<Integer, LinkedList<Integer>> table, int level) {
        if(root != null) {
            if(!table.containsKey(level)) {
               table.put(level, new LinkedList<>());
            }

            table.get(level).add(root.value);

            listOfDepthsHelper(root.left, table, level + 1);
            listOfDepthsHelper(root.right, table, level + 1);
        }
    }

    public List<LinkedList<TreeNode>> listOfDepthsBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if(root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            list.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent: parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }

                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return list;
    }

    public boolean isBalanced(TreeNode root) {
        /*
            IDEA: for a tree to be balanced, the left subtree must be balanced and the right subtree must be balanced
            A balanced tree is a tree such that the heights of the two subtrees of any node never differ by more than one
        */

        return checkHeight(root) != Integer.MIN_VALUE;

    }

    private int checkHeight(TreeNode root) {
        if(root == null) return -1;

        int left = checkHeight(root.left);
        if(left == Integer.MIN_VALUE) return left;

        int right = checkHeight(root.right);
        if(right == Integer.MIN_VALUE) return right;

        int heightDiff = left - right;
        if(Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(left, right) + 1;
        }
    }


}
