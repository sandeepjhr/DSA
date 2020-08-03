package leetCode.TreesGraph;

public class SymmetricTree {
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
        TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(2);
          root.left.left = new TreeNode(3);
          root.left.right = new TreeNode(4);
          root.right.left = new TreeNode(4);
          root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);

    }
    private static boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
       // if(left.left.val == right.right.val && right.left.val == left.right.val) return true;
       // return isSymmetricHelper(left.left,left.right);

    }
}
