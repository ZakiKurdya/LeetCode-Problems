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
    private List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left);
        helper(node.right);
        result.add(node.val);  
    }
}