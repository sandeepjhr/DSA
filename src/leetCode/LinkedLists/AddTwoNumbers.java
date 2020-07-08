package leetCode.LinkedLists;

public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val= val;this.next=next;}
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode  result = addTwoNo(l1, l4);
        while(result!=null){
            System.out.print(result.val+",");
            result = result.next;
        }

    }

    /**
     *
     *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    private static ListNode addTwoNo(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            first.next = new ListNode(carry%10);
            carry /= 10;
            first = first.next;
        }
        return dummy.next;
    }
}
