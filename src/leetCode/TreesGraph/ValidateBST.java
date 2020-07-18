package leetCode.TreesGraph;

public class ValidateBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
      //  root.left = new TreeNode(1);
       // root.right = new TreeNode(3);
        System.out.println(isValidBSTRecursion(root));
    }

    private static boolean isValidBSTRecursion(TreeNode root) {
        return isValidBSTRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTRecursion(TreeNode node, long lower_limit, long upper_limit) {
        if (node == null) return true; //an empty tree is BST
        if (node.val <= lower_limit || node.val >= upper_limit) return false;
        return isValidBSTRecursion(node.left, lower_limit, node.val) && isValidBSTRecursion(node.right, node.val, upper_limit);
    }

}
