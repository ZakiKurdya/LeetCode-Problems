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
        Queue<TreeNode> levels = new LinkedList<>();
        List<Boolean> isNull = new ArrayList<>();
        
        levels.add(root);
        isNull.add(false);
        isNull.add(null);
        
        int level = 2, sum = 0;
        boolean isLevelNull = false;
        
        while (!levels.isEmpty()) {
            TreeNode temp = levels.remove();
            
            sum +=2;
            
            if (temp == null) {
                isLevelNull = true;
                
                isNull.add(true);
                isNull.add(true);
            } else {
                isLevelNull = false;
                
                isNull.add(temp.left == null ? true : false);
                levels.add(temp.left);
                
                isNull.add(temp.right == null ? true : false);
                levels.add(temp.right);
            }
            
            if (level == sum) {
                isNull.add(null);
                sum = 0;
                level *= 2;
                
                if (isLevelNull)
                    break;
            }
        }
                
        boolean isNullOccur = false;        
        for (int i = 1; i < isNull.size(); i++) {
            if (isNull.get(i) != null && !isNull.get(i) && isNullOccur)
                return false;
            
            if (isNull.get(i) != null && isNull.get(i))
                isNullOccur = true;
        }
        
        return true;
    }
}