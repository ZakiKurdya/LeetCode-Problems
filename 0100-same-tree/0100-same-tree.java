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
    private boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p, q);
        return isSame;
    }

    private void helper(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            isSame = false;
            return;
        } else if (p != null && q == null) {
            isSame = false;
            return;
        } else if (p == null && q == null)
            return;
            
        if (p.val != q.val) {
            isSame = false;
            return;
        }

        helper(p.left, q.left);
        helper(p.right, q.right);    
    }
}