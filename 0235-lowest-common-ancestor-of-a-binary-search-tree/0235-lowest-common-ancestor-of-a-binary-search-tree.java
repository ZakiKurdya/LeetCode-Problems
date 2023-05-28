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
        
        return findLCA(root, p, q);
    }
    
    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        
        if (node.val > q.val)
            return findLCA(node.left, p, q);
        else if (node.val < p.val)
            return findLCA(node.right, p, q);
        else
            return node;
    }
}