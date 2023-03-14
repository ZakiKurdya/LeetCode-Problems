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
    private Stack<TreeNode> roots;
    private int sum;
    private StringBuilder temp;
    
    public int sumNumbers(TreeNode root) {
        this.roots = new Stack<>();
        this.sum = 0;
        this.temp = new StringBuilder();
        
        postOrder(root);
        
        return sum;
    }
    
    private void postOrder(TreeNode node) {
        if (node == null)
            return;
        
        temp.append(node.val);
        roots.push(node);
        
        postOrder(node.left);
        postOrder(node.right);
        
        if (isLeaf(node))            
            sum += Integer.parseInt(temp.toString());
        
        if (!roots.isEmpty() && roots.peek() == node) {
            roots.pop();
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}