class Solution {
    public int partitionString(String s) {
        Set<Character> temp = new HashSet<>();
        int counter = 0;
        
        for (char c : s.toCharArray()) {
            if (!temp.contains(c))
                temp.add(c);
            else {
                temp.clear();
                temp.add(c);
                counter++;
            }
        }
        
        return counter + 1;
    }
}