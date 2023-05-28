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
    private TreeNode LCA = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
        postOrder(root, p.val, q.val);
        
        return LCA;
    }
    
    private boolean postOrder(TreeNode node, int p, int q) {
        if (node == null)
            return false;
        
        boolean left = postOrder(node.left, p, q);
        boolean right = postOrder(node.right, p, q);
        boolean equal = node.val == p || node.val == q;
        
        if ((left && right) || (equal && right) || (equal && left))
            LCA = node;
        
        if (equal) return true;
        
        return left || right;
    }
}