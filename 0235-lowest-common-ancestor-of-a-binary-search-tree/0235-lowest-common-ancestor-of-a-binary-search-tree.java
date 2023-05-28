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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        
        return dfs(root, p, q);
    }
    
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        
        if (node.val > q.val)
            return dfs(node.left, p, q);
        else if (node.val < p.val)
            return dfs(node.right, p, q);
        else
            return node;
    }
}