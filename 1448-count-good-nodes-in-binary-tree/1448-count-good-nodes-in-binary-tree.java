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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    public int dfs(TreeNode root, int max) {
        if (root == null)
            return 0;
               
        int ans = 0;
        if (max <= root.val) {
            max = root.val;
            ans ++;
        }
        
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        
        return ans + left + right;
    }
}