class Solution {
    public boolean isPalindrome(String s) {
        if (s == " " || s.length() == 1)
            return true;
        
        boolean check = true;
        
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        
        outer:
        while (l < r) {
            int left = (int) s.charAt(l);
            while (left > 122 || left < 48 || (left < 97 && left > 57)) {
                l++;
                continue outer;
            }
            
            int right = (int) s.charAt(r);
            while (right > 122 || right < 48 || (right < 97 && right > 57)) {
                r--;
                continue outer;
            }
            
            if (left == right) {
                l++;
                r--;
            } else
                return false;
        }
        
        return check;
    }
}