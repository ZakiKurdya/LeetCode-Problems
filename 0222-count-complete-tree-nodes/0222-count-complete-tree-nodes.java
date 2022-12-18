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
    private int sum = 0;
    public int countNodes(TreeNode root) {
        helper(root);
        return sum;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left); 
        sum ++;
        helper(node.right); 
    }
}