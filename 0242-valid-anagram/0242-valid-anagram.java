class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        
        for (int i = 0; i < t.length(); i++) {
            if (!freq.containsKey(t.charAt(i)))
                return false;
            
            freq.put(t.charAt(i), freq.get(t.charAt(i)) - 1);
            
            if (freq.get(t.charAt(i)) == 0)
                freq.remove(t.charAt(i));
        }
        
        return freq.size() == 0;
    }
}