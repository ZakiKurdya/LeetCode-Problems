class Solution {
    public boolean detectCapitalUse(String word) {
        return word.toLowerCase().equals(word) ||
               word.toUpperCase().equals(word) ||
               (Character.isUpperCase(word.charAt(0)) &&
                word.substring(1).toLowerCase().equals(word.substring(1)));
    }
}