class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] list = s.split(" ");
        boolean isFound = false;
        Set<String> temp = new HashSet<>();
        if (pattern.length() != list.length)
        return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(list[i]))
                    return false;    
            } else {
                if (temp.add(list[i]))
            
                map.put(pattern.charAt(i), list[i]);
                else return false;

            }
        }
        return true;
    }
}