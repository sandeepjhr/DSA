package leetCode.TreesGraph;

public class LCAofBT {
    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){ val = x;}
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
       if(root == null || root == p || root == q) return root;

       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);

       if(left != null && right != null) return root;
       if(left == null && right == null) return null;

       return left != null ? left : right;
    }
}
