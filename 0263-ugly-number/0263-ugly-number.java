class Solution {
    public boolean isUgly(int n) {
        if(n < 1)
            return false;
        if(n < 7)
            return true;
        while(n % 2 == 0)
            n /= 2;
        while(n % 3 == 0) 
            n /= 3;
        while(n % 5 == 0)
            n /= 5;
        return n == 1 ? true : false;  
    }
}