class MyHashSet {
    private static class ListNode {
        int value;
        ListNode next;
        
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    ListNode[] table;
    
    public MyHashSet() {
        table = new ListNode[1000000];
    }
    
    public void add(int key) {
        int index = getHash(key);
        
        if (!contains(key)) {
            ListNode temp;
            if (table[index] == null) {
                temp = new ListNode(key);
                table[index] = temp;
            } else {
                temp = table[index];
                ListNode walker = temp;

                while (walker.next != null)
                    walker = walker.next;

                walker.next = new ListNode(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = getHash(key);
        
        if (table[index] != null) {
            ListNode walker = table[index];
            
            if (walker.value == key) {
                walker = walker.next;
                table[index] = walker;
            } else {
                while (walker.next != null) {
                    if (walker.next.value == key)
                        walker.next = walker.next.next;
                
                    walker = walker.next;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int index = getHash(key);
        
        if (table[index] == null)
            return false;
        else {
            ListNode walker = table[index];
            
            while (walker != null) {
                if (walker.value == key)
                    return true;
                
                walker = walker.next;
            }
            
            return false;
        }
    }
    
    private int getHash(int key) {
        return key % 1000000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */