package leetCode.LinkedLists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(4);
        Node l3 = new Node(5);
        l1.next = l2;
        l2.next = l3;

        Node l4 = new Node(1);
        Node l5 = new Node(3);
        Node l6 = new Node(4);
        l4.next = l5;
        l5.next = l6;

        Node l7 = new Node(2);
        Node l8 = new Node(6);
        l7.next = l8;

        Node[] lists = {l1, l4, l7};

        Node result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }

    private static Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0) return null;
        //PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val-b.val);//min heap PQ
        for (Node list : lists) {// adding the first node from all list to the PQ
            if (list != null) {
                pq.offer(list);
            }
        }
        Node dummy = new Node(-1);
        Node current = dummy;

        /**
         * from PQ fetch the smallest item which will be automatically done by poll() because current PQ is a min Heap and
         * Poll() will fetch from the root which will be smallest
         * After fetching smallest, add the next item of that node into the PQ and keep repeating this process until
         * PQ become empty
         */

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (n.next != null) {
                pq.offer(n.next);
            }
            current.next = n;
            current = n;
        }
        return dummy.next;
    }
}
