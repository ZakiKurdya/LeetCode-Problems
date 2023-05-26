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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();        
        if (root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Integer> temp;
        boolean flag = true;

        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int level = queue.size();
            
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                
                if (flag)
                    temp.add(queue.remove().val);
                else
                    temp.add(0, queue.remove().val);
            }
            
            flag = !flag;
            result.add(temp);
        }
        
        return result;
    }
}