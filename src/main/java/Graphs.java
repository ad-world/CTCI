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

    public boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }

        // check if min is not null and val is smaller than min OR max is not null and val is greater than max
        // if so, return false
        if((min != null && root.value <= min) || (max != null && root.value > max)) {
            return false;
        }

        // check left BST, with new max (current node value) and right BST with new min (current node value)
        return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
    }

    public TreeNode successor(TreeNode node, TreeNode root) {
        // if node has a right child, then return left most child of right child
        // if node does not have right child, go up while node is right child of parent
        // once no more right child, return parent

        //        10
        //     5      15
        //   2   8   11  19
        //  1 4   9   12   20

        // find inorder successor of 9
        // 9 is right child of 8 -> 8 is right child of 5 -> 5 is left child of 10 (return 10)

        // We do not have access to parent
        if(node == null) {
            return null;
        }

        if(node.right != null) {
            TreeNode temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }

            return temp;
        } else {
            TreeNode temp = node;
            TreeNode parent = node.getParent(root);

            while(parent != null && parent.left != temp) {
                temp = parent;
                parent = parent.getParent(root);
            }
            return parent;
        }


    }


}
