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
    private int kthSmallestValue = 0, counter = 1;
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        
        return kthSmallestValue;
    }
    
    private void inOrder(TreeNode root, int k) {
        if (root == null)
            return;
        
        inOrder(root.left, k);
        
        if (counter++ == k)
            kthSmallestValue = root.val;
        
        inOrder(root.right, k);
    }
}