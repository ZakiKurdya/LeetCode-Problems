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

// DFS Solution
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null)
            preOrder(root, 0);
        
        return result;
    }
    
    private void preOrder(TreeNode node, int level) {
        if (node == null)
            return;
        
        // create a new level
        if (result.size() <= level)
            result.add(new ArrayList<>());

        result.get(level).add(node.val);
		
        preOrder(node.left, level + 1);
        preOrder(node.right, level + 1);
    }
}