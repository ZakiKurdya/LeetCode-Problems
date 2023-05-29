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
    private TreeMap<Integer, List<Integer>> map;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        map = new TreeMap<>();
        
        preOrder(root, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : map.values())
            result.add(list);
        
        return result;
    }
    
    private void preOrder(TreeNode node, int level) {
        if (node == null)
            return;
        
        List<Integer> temp = map.getOrDefault(level, new ArrayList<>());
        temp.add(node.val);
        
        map.put(level, temp);
        
        preOrder(node.left, level + 1);
        preOrder(node.right, level + 1);
    }
}