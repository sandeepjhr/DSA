package leetCode.LinkedLists;

public class MergeTwoSortedLists {
    private static class ListNode {
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
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(2);
        l4.next = l5;
        l5.next = l6;

        ListNode result = mergeLists(l1, l4);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    first.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else if (l2.val < l1.val) {
                    first.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    first.next = new ListNode(l1.val);
                    first = first.next;
                    first.next = new ListNode(l2.val);
                    l1 = l1.next;
                    l2 = l2.next;
                }
            } else if (l1 == null && l2 != null) {
                first.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                first.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            first = first.next;
        }
        return dummy.next;
    }
}

