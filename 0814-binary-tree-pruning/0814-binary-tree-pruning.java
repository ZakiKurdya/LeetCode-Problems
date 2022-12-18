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
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null)
            return false;
        
        boolean leftContainsOne = containsOne(node.left);
        boolean rightContainsOne = containsOne(node.right);

        if (!leftContainsOne)
            node.left = null;
    
        if (!rightContainsOne)
            node.right = null;
        
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}