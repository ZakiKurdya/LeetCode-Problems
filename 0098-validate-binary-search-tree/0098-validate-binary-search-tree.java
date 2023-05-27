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
    private boolean isValid = true;
    private long prevMax = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        
        return isValid;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);

        if (node.val > prevMax)
            prevMax = node.val;
        else
            isValid = false;
        
        inOrder(node.right);
    }
}