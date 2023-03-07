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
    Set<Integer> temp;
    
    public boolean findTarget(TreeNode root, int k) {
        temp = new HashSet<>();
        inOrder(root);

        for (int node : temp) {
            if (temp.contains(k - node) && k - node != node)
                return true;
        }
        
        return false;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        temp.add(node.val);
        inOrder(node.right);
    }
}