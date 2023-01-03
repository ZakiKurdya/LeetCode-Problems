class Solution {
    public int minDeletionSize(String[] strs) {
        int counter = 0, col = strs[0].length();
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < strs.length - 1; r++) {
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}