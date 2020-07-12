package leetCode.LinkedLists;

public class ReverseNodesKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = reverseKGroup(l1, 3);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }

    /**
     *
     *(1)first we need to reverse only k node so we need to count the number of nodes we have transversed
     *
     * (2)at the last we use an recursive function to reverse the next k node an get the starting node of that group
     *    and that will be our next node for current group
     */
    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummy;

        while(current != null){
            ListNode start = current;
            int count = 0;

            //first move current pointer till k index
            while(current != null && count < k){
                current = current.next;
                count++;
            }

            //if count is k it means we can reverse from start till k values
            //after reverse need to point the prev.next to reversed list
            //also need to assign make prev = start so we can point prev.next in next iteration
            if(count == k){
                prev.next = reverse(start,k);
                prev = start;
            }

            //if count is not equals k it means we need not reverse the list
            //we can simply assign prev.next to start.
            else{
                prev.next = start;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        int count = 0;
        while(count != k && head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
            count++;
        }

        return prev;
    }

}
