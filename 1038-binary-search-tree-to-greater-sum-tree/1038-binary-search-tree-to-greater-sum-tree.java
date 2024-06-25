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

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        
        dfs(node.right);
        
        this.sum += node.val;
        node.val = this.sum;

        dfs(node.left);    
    }
}