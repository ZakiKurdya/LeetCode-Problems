/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverseListNode(head);

        ListNode walker = head;
        ListNode next = walker.next;

        while (next != null) {
            while (next != null && walker.val > next.val) {
                walker.next = next.next;
                next = next.next;
            }

            walker = walker.next;

            if (walker != null)
                next = walker.next;
        }

        head = reverseListNode(head);

        return head;

    }

    private ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode walker = head;
        ListNode next = walker.next;

        while (next != null) {
            walker.next = prev;
            prev = walker;
            walker = next;
            next = next.next;
        }
        walker.next = prev;

        return walker;
    }
}