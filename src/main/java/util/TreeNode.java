package util;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public TreeNode getParent(TreeNode root) {
        TreeNode lastSeen = root;

        while(root != this) {
            if(root.value > this.value) {
                lastSeen = root;
                root = root.left;
            } else if (root.value < this.value) {
                lastSeen = root;
                root = root.right;
            } else {
                return lastSeen;
            }
        }

        return lastSeen;
    }
}

