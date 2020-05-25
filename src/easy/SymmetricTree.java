package easy;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return is_Symmetric(root.left, root.right);
        }
    }

    public boolean is_Symmetric(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return is_Symmetric(p.left, q.right) && is_Symmetric(p.right, q.left);
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
