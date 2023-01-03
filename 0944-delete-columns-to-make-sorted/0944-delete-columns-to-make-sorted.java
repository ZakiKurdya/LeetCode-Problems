class Solution {
    public int minDeletionSize(String[] strs) {
        int counter = 0, col = strs[0].length();
        for (int c = 0; c < col; c++) {
            for (int r = 1; r < strs.length; r++) {
                if (strs[r - 1].charAt(c) > strs[r].charAt(c)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}