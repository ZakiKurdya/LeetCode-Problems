class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!vowels.contains(chars[l]))
                l ++;
            else if (!vowels.contains(chars[r]))
                r --;
            else {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l ++;
                r --;
            }        
        }
        
        return new String(chars);
    }
}