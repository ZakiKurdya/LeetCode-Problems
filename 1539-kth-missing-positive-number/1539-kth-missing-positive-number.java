class Solution {
    public int findKthPositive(int[] arr, int k) {
        int counter = 0, i = 1;
        
        while (counter != k) {
            if (Arrays.binarySearch(arr, i++) < 0)
                counter++;
        }

        return i - 1;
    }
}