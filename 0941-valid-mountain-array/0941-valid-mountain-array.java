class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] > arr[1])
            return false;
        boolean isIncreased = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return false;
            else if (arr[i] > arr[i + 1] && isIncreased)
                isIncreased = false;
            else if (arr[i] < arr[i + 1] && !isIncreased)
                return false;
        }
        return isIncreased == false;
    }
}