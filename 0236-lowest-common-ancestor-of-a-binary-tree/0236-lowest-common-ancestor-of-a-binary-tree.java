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

        
      
        

        if (LCA == null && ((left && right) || ((node.val == p || node.val == q) && right )
           ||( (node.val == p || node.val == q) && left))) {
            LCA = node;
        }
        
          if (node.val == p || node.val == q)
            return true;
        
        return left || right;
    }
}