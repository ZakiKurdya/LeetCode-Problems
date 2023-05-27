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
    // {col : {row : [nodes]}}
    private TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        map = new TreeMap<>();
        
        dfs(root, 0, 0);
        
        for (TreeMap<Integer, List<Integer>> item : map.values()) {
            List<Integer> colNodes = new ArrayList<>();
            
            for (List<Integer> list : item.values()) {
                Collections.sort(list);
                colNodes.addAll(list);
            }
            
            result.add(colNodes);
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int col, int row) {
        if (node == null)
            return;
        
        dfs(node.left, col - 1, row + 1);
        
        TreeMap<Integer, List<Integer>> tempMap = map.getOrDefault(col, new TreeMap<>());
        List<Integer> tempList = tempMap.getOrDefault(row, new ArrayList<>());
        
        tempList.add(node.val);
        tempMap.put(row, tempList);
        
        map.put(col, tempMap);
        
        dfs(node.right, col + 1, row + 1);
    }
}