class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int t0 = 0, t1 = 1, t2 = 1, temp;
        for (int i = 1; i <= n - 2; i++) {
            temp = t2;
            t2 = t0 + t1 + t2;
            t0 = t1;
            t1 = temp;
        }
        return t2;
    }
}