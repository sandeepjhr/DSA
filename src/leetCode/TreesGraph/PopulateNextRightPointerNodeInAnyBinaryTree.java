package leetCode.TreesGraph;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerNodeInAnyBinaryTree {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    private Node connect(Node root){
        if(root == null) return null;
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = findNext(root.next);
        }else if(root.left != null){// means root.right is NULL
            root.left.next = findNext(root.next);
        }else if(root.right != null){// means root.left is NULL
            root.right.next = findNext(root.next);
        }
       //right first because left node might need the reference of parent neighbour right node child
        connect(root.right);
        connect(root.left);

        return root;

    }

    private Node findNext(Node root){
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;

        return findNext(root.next);
    }

    private void connect2(Node root){
        while(root != null){// vertical traverse loop
            Node current = root;
            while(current != null){
                if(current.left != null && current.right != null){
                    current.left.next = current.right;
                    current.right.next = findNext(current.next);
                }else if(current.left!= null || current.right != null){
                    findNext(current).next = findNext(current.next);
                }
                root = findNext(root);
            }

        }
    }
}
