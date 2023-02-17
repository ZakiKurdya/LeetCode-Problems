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
    public ListNode middleNode(ListNode head) {
        int middle = listLength(head) / 2, counter = 0;
        while (counter != middle) {
            head = head.next;
            counter++;
        }
        return head;
    }
    
    private byte listLength(ListNode node) {
        byte length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}