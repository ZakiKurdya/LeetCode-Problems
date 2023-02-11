class Solution {
    public int arraySign(int[] nums) {
        byte temp = 1;
        for (short i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                temp *= -1;
            else if (nums[i] == 0)
                temp = 0;
        }
        if (temp == 1)
            return 1;
        else if (temp == -1)
            return -1;
        else
            return 0;
    }
}