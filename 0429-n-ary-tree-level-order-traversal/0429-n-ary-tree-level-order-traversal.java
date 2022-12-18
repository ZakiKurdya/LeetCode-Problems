/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        this.levelOrder(result, root, 1);
        return result;
    }
    
    private void levelOrder(List<List<Integer>> list, Node node, int level) {
        if (node == null)
            return;
        
        if (list.size() < level)
            list.add(new ArrayList<>());
        list.get(level - 1).add(node.val);
        
        for (Node child : node.children)
            levelOrder(list, child, level + 1);
    }
}