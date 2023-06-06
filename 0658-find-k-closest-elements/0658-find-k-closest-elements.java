class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (x - arr[left] > arr[right] - x)
                left++;
            else
                right--;
        }

        for (int i = left; i <= right; i++)
            result.add(arr[i]);
    
        return result;
    }
}