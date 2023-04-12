class Solution {
    public int minPartitions(String n) {
        int digit = -1;
        
        for (int i = 0; i < n.length(); i++)
            digit = Math.max(digit, n.charAt(i) - '0');
        
        return digit;
    }
}