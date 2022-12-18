class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            DFS(n - 1, k, i, result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private void DFS(int n, int k, int num, List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }
        
        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + k);
        if (k != 0)
            nextDigits.add(tailDigit - k);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                DFS(n - 1, k, newNum,  result);
            }
        }
        
    }
}