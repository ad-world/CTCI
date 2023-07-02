import org.junit.jupiter.api.Test;
import util.Graph;
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void minimalBstTest() {
        Graphs graphProblems = new Graphs();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = graphProblems.createMinimalBST(array);
        assertEquals(root.value, 4);
        assertEquals(root.left.value, 2);
        assertEquals(root.right.value, 6);
        assertEquals(root.left.left.value, 1);
        assertEquals(root.left.right.value, 3);
        assertEquals(root.right.left.value, 5);
        assertEquals(root.right.right.value, 7);

        int[] array2 = {};
        TreeNode root2 = graphProblems.createMinimalBST(array2);
        assertNull(root2);
    }

    @Test
    public void listOfDepthsTest() {
        Graphs graphProblems = new Graphs();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = graphProblems.createMinimalBST(array);
        List<LinkedList<Integer>> result = graphProblems.listOfDepths(root);

        assertEquals(4,  result.get(0).get(0));
        assertEquals(2, result.get(1).get(0));
        assertEquals(6, result.get(1).get(1));
    }

    @Test
    public void listOfDepthsBFSTest() {
        Graphs graphProblems = new Graphs();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = graphProblems.createMinimalBST(array);
        List<LinkedList<TreeNode>> result = graphProblems.listOfDepthsBFS(root);

        assertEquals(4,  result.get(0).get(0).value);
        assertEquals(2, result.get(1).get(0).value);
        assertEquals(6, result.get(1).get(1).value);
    }

    @Test
    public void isBalancedTest() {
        Graphs graphProblems = new Graphs();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = graphProblems.createMinimalBST(array);

        assertTrue(graphProblems.isBalanced(root));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);

        assertFalse(graphProblems.isBalanced(root2));
    }
}