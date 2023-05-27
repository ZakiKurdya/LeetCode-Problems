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
    private TreeNode prev;
    private int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {        
        inOrder(root);
        
        return min;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;
        
        inOrder(node.left);
        
        if (prev != null)
            min = Math.min(min, Math.abs(node.val - prev.val));
        
        prev = node;
        
        inOrder(node.right);
    }
}