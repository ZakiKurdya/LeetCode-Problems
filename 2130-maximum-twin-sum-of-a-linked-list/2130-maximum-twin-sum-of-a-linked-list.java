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
    public int pairSum(ListNode head) {
        List<Integer> nodeVals = new ArrayList<>();
        
        ListNode cur = head;
        while (cur != null) {
            nodeVals.add(cur.val);
            
            cur = cur.next;
        }
        
        int sum = 0;
        for (int i = 0; i < nodeVals.size() / 2; i++)
            sum = Math.max(sum, nodeVals.get(i) + nodeVals.get(nodeVals.size() - 1 - i));
        
        return sum;
    }
}