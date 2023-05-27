class Trie {
    static class TrieNode {
        char value;
        boolean isCompleteWord;
        TrieNode[] children;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
        
        public TrieNode(char value) {
            this.value = value;
            this.children = new TrieNode[26];
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
            
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
            else {
                TrieNode temp = new TrieNode(c);
                cur.children[c - 'a'] = temp;
                
                cur = temp;
            }
        }
        
        cur.isCompleteWord = true;        
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
            else
                return false;
        }
        
        return cur.isCompleteWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
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