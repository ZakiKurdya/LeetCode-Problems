class Solution {
    public int minPartitions(String n) {
        int digit = -1;
        
        for (char c : n.toCharArray())
            digit = Math.max(digit, c - '0');
        
        return digit;
    }
}