package easy;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */

public class MaximumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        count_Depth(root, 0);
        return max_count;
    }

    int max_count = 0;

    public void count_Depth(TreeNode p, int count) {
        if (p == null) {
            if (count > max_count) {
                max_count = count;
            }
            return;
        }
        count++;
        count_Depth(p.left, count);
        count_Depth(p.right, count);
    }

    public static void main(String[] args) {

    }
}
