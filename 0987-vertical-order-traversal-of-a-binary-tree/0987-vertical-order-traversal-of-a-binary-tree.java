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
    private final Map<Integer, List<Integer>> columns = new HashMap<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        int firstCol = Integer.MAX_VALUE;
        for (int i : columns.keySet())
            firstCol = Math.min(firstCol, i);
        
        List<List<Integer>> result = new ArrayList<>();
    
        while (columns.containsKey(firstCol)) {
            List<Integer> temp = columns.get(firstCol);
            Map<Integer, List<Integer>> rows = new HashMap<>();
            
            for (int i = 0; i < temp.size(); i += 2) {
                List<Integer> rowList;
                if (rows.containsKey(temp.get(i))) {
                    rowList = rows.get(temp.get(i));
                    rowList.add(temp.get(i + 1));
                } else {
                    rowList = new ArrayList<>();
                    rowList.add(temp.get(i + 1));
                }
                rows.put(temp.get(i), rowList);           
            }
            
            PriorityQueue<Integer> rowOrder = new PriorityQueue<>();
            for (int i : rows.keySet())
                rowOrder.add(i);
            
            List<Integer> list = new ArrayList<>();
            int rowNum = rowOrder.poll();
            while (rows.containsKey(rowNum)) {
                List<Integer> row = rows.get(rowNum);
                Collections.sort(row);
                list.addAll(row);
                if (!rowOrder.isEmpty())
                    rowNum = rowOrder.poll();
                else
                    rowNum = Integer.MAX_VALUE;
            }
            
            result.add(list);
            firstCol ++;
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int r, int c) {
        if (node == null) // base case
            return;
        
        List<Integer> temp;
        if (columns.containsKey(c)) {
            temp = columns.get(c);
            temp.add(r);
            temp.add(node.val);
        } else {
            temp = new ArrayList<>();
            temp.add(r);
            temp.add(node.val);
        }
        columns.put(c, temp);

        dfs(node.left, r + 1, c - 1); // left
        dfs(node.right, r + 1, c + 1); // right
    }
}