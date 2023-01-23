class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freq = new int[n + 1];
        for (int i = 0; i < trust.length; i++)
            freq[trust[i][1]]++;
        int judge = -1;
        boolean isExist = true;
        for (int i = 0; i <= n; i++)
            if(freq[i] == n - 1)
                judge = i;
        for (int i = 0; i < trust.length; i++)
            if (trust[i][0] == judge)
                isExist = false;
        if (isExist) return judge;
        return -1;
    }
}