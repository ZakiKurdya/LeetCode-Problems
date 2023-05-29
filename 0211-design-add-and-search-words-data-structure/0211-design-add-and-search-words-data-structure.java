class WordDictionary {
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

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return dfs(word, root, 0);
    }
    
    private boolean dfs(String word, TrieNode node, int index) {
        TrieNode cur = node;
        
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode temp : cur.children)
                    if (temp != null && dfs(word, temp, i + 1))
                        return true;
                
                return false;
            }
            
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
            else
                return false;
        }

        return cur.isCompleteWord;
    } 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */