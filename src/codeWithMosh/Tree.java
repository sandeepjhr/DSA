package codeWithMosh;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value=value;
        }
        public String toString(){
            return  "Node= "+value;
        }
    }

    private Node root;
    public void insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }

        Node current = root;
        while(true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }else{
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;

            }
        }
    }

    public boolean find(int findValue){
        if(root.value == findValue){
            return true;
        }
        Node current = root;

        while(current != null){
            if(findValue < current.value) current = current.leftChild;
            else if(findValue > current.value) current = current.rightChild;
            else return true;
        }

        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    private void traversePreOrder(Node root){
        // root left right
        if(root == null) return;
        System.out.print(root.value+" ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    private void traverseInOrder(Node root){
        // left root right
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value+" ");
        traverseInOrder(root.rightChild);
    }
    private void traversePostOrder(Node root){
        // left right root
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value+" ");
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    private int height(Node root){
        if(root == null) return -1;
        if(isLeaf(root)) return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    private int min(Node root){
        if(isLeaf(root)) return root.value;
        int leftMin = min(root.leftChild);
        int rightMin = min(root.rightChild);

        return Math.min(Math.min(leftMin,rightMin), root.value);
    }

    public boolean equal(Tree other){
        if(other == null) return false;
        return equal(root, other.root);
    }

    private boolean equal(Node first, Node second){
        if(first == null && second == null) return true;
        if(first != null && second != null){
            return first.value == second.value
                    && equal(first.leftChild, second.leftChild)
                    && equal(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null) return true;
        if(root.value < min || root.value > max) return false;
       return isBinarySearchTree(root.leftChild, min, root.value-1) && isBinarySearchTree(root.rightChild, root.value+1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null) return;
        if(distance == 0){
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    public void traverseLevelOrder(){
        for(int i = 0; i<= height(); i++)
            System.out.println(getNodesAtDistance(i));
    }

    public void countLeaves(){
        int count = countLeaves(root, 0);
        System.out.println("Total leafs are: "+count);
    }

    private int countLeaves(Node node, int count){
        if(isLeaf(node)){
            count++;
            return count;
        }

        return countLeaves(node.leftChild, count)+ countLeaves(node.rightChild, count);
    }

    public Node getParent(int value){
        Node parent = getParent(root, value);
        if(parent == null) {
            return null;
        }
        return parent;
    }

    private Node getParent(Node node, int value){
        if(isLeaf(node)){
            return null;
        }
        if(node.leftChild.value == value || node.rightChild.value == value){
            return node;
        }else if(getParent(node.leftChild, value) != null){
            return node.leftChild;
        } else if(getParent(node.rightChild, value) != null){
            return node.rightChild;
        }
        return null;
    }

    public boolean areSibling(int value1, int value2){
        if(getParent(value1)!=null && getParent(value2)!=null){
            return (getParent(value1) == getParent(value2));
        }
        return false;
    }

    public List<Integer> getAncestors(int value){
        List<Integer> list = new ArrayList<>();
        if(root.value == value){
            list.add(-1);
            return list;
        }
        Node parent = getParent(value);
        if(parent == null){
            list.add(-1);
            return list;
        }
        list.add(parent.value);
        while(parent != root){
            parent = getParent(parent.value);
            list.add(parent.value);
        }


        return list;
    }

    public int size(){
        if(root == null ) return 0;
        if(isLeaf(root)) return 1;

        int count = 1;
        count = size(root, count);
        return count;
    }

    private int size(Node node, int count) {
      /*  if(isLeaf(node)) {
            return count;
        }*/
        if(node.leftChild != null) count = size(node.leftChild, ++count);
        if(node.rightChild != null) count = size(node.rightChild, ++count);
        return count;
    }


}
