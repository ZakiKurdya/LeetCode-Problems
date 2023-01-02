class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCap = Character.isUpperCase(word.charAt(0));
        if (isFirstCap) {
            if (word.length() > 1) {
                boolean isSecondCap = Character.isUpperCase(word.charAt(1));
                if (isSecondCap) {
                    for (int i = 2; i < word.length(); i++)
                        if (Character.isLowerCase(word.charAt(i)))
                            return false;
                } else {
                    for (int i = 2; i < word.length(); i++)
                        if (Character.isUpperCase(word.charAt(i)))
                            return false;
                }
            } else
                return true;
        } else {
            for (int i = 1; i < word.length(); i++)
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
        }
        return true;
    }
}