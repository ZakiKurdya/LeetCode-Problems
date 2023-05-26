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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean isNull = false;
        while (queue.size() != 0) {
            TreeNode node = queue.remove();
            
            if (node == null)
                isNull = true;
            else {
                if (isNull)
                    return false;
            
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    
        return true;
    }
}