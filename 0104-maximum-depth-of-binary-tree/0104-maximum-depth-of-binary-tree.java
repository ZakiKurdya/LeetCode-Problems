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
    private int depth = Integer.MIN_VALUE;
    
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        
        return depth;
    }
    
    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            depth = Math.max(depth, sum);
            return;
        }
        
        dfs(node.right, sum + 1);
        dfs(node.left, sum + 1);
    }
    
    
}