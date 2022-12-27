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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode result = head;
        boolean isFirst = true;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                if (!isFirst) {
                    result.next = cur;
                    result = cur;
                }else 
                    isFirst = false;
            }
            cur = cur.next;
        }
result.next = cur;        return head;
    }
}