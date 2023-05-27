class Trie {
    static class TrieNode {
        char value;
        boolean isCompleteWord;
        Map<Character, TrieNode> children;
        
        public TrieNode() {
            this.children = new HashMap<>();
        }
        
        public TrieNode(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else {
                TrieNode temp = new TrieNode(c);
                cur.children.put(c, temp);
                
                cur = temp;
            }
        }
        
        cur.isCompleteWord = true;        
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else
                return false;
        }
        
        return cur.isCompleteWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else
                return false;
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */