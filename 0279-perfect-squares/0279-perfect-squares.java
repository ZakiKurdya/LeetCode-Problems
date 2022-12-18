class Solution
{
    public int numSquares(int n)
    {
        if (Math.pow((int)Math.sqrt(n),2) == n) return 1;
        
        for (int i = 1; i <= (int)Math.sqrt(n); ++i)
            if (n - i*i == Math.pow((int)Math.sqrt(n - i*i),2))
                return 2;
                
        while (n % 4 == 0) n /= 4; 
        if   (n % 8 != 7) return 3; 
                
        return 4;
    }
}