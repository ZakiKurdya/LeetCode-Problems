class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            chars1[word1.charAt(i) - 'a']++;
            chars2[word2.charAt(i) - 'a']++;
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 25; i >= 0; i--) {
            if (chars1[i] == 0 && chars2[i] == 0)    
                break;
            if (chars1[i] != chars2[i])
                return false;
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
        }
        return set1.equals(set2);
    }
}