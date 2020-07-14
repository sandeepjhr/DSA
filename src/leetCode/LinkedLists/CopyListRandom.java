package leetCode.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandom {
    private static class Node {
        int val;
        Node random;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public static void main(String[] args) {
        Node l1 = new Node(7);
        Node l2 = new Node(13);
        Node l3 = new Node(11);
        Node l4 = new Node(10);
        Node l5 = new Node(1);
        l1.next = l2; l1.random = null;
        l2.next = l3; l2.random = l1;
        l3.next = l4; l3.random = l5;
        l4.next = l5; l4.random = l3; l5.random = l1;
        Node result = copyRandList(l1);
        while (result != null) {
            if(result.random == null){
                System.out.println(result.val + ", null" );
            }else{
                System.out.println(result.val + ","+ result.random.val);
            }

            result = result.next;
        }
    }

    private static Node copyRandList(Node head){
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node current = dummy;
        Node newNode = null;
        /**
         * Map will store node and it's corresponding new node
         */

        while(head != null){
            if(!map.containsKey(head)){
                newNode = new Node(head.val);
                map.put(head, newNode);
            }
            else{
                newNode = map.get(head);
            }
            if(head.random != null){
                if(!map.containsKey(head.random)){
                    newNode.random = new Node(head.random.val);
                    map.put(head.random, newNode.random);

                }else{
                    newNode.random = map.get(head.random);
                }
            }

            current.next = newNode;
            current = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}
