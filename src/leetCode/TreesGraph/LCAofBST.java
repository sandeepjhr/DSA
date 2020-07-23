package leetCode.TreesGraph;

public class LCAofBST {
    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){ val = x;}
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            //if pVal, qVal is lower and higher than the root, it means root will be the earliest common point
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

}
