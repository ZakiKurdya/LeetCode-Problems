/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode lca;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.lca = root;
        
        dfs(root, p, q);
        
        return this.lca;
    }
    
    private void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return;
        
        if (node.val == p.val || node.val == q.val ||
            (node.val > Math.min(p.val, q.val) && node.val < Math.max(p.val, q.val))) {
            lca = node;
            return;
        }
        
        if (node.val > p.val && node.val > q.val)
            dfs(node.left, p, q);
        
        if (node.val < p.val && node.val < q.val)
            dfs(node.right, p, q);
    }
}