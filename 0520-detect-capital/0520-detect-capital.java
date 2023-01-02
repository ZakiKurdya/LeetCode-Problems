class Solution {
    public boolean detectCapitalUse(String word) {
        String temp = word.substring(1);
        return word.toLowerCase().equals(word) ||
               word.toUpperCase().equals(word) ||
               (Character.isUpperCase(word.charAt(0)) &&
                temp.toLowerCase().equals(temp));
    }
}