/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> temp; // sorted
    
    public int minDiffInBST(TreeNode root) {
        temp = new ArrayList<>();
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size() - 1; i++)
            min = Math.min(min, temp.get(i + 1) - temp.get(i));
        return min;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        temp.add(node.val);
        inOrder(node.right);
    }
}