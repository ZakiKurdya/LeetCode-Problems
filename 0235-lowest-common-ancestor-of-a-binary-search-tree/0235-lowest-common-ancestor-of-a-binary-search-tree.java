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
       if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        
        if((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val) ){
            return root;
        }else if((root.val < p.val && p.val < q.val) || (root.val < q.val && q.val < p.val)){
            return lowestCommonAncestor(root.right, p, q);
        }else  
            return lowestCommonAncestor(root.left, p, q);
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