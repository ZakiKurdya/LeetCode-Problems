class Solution {
    public boolean isPalindrome(String s) {
        if (s == " " || s.length() == 1)
            return true;
        
        boolean check = true;
        
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        
        outer:
        while (l < r) {
            while ((int) s.charAt(l) > 122 ||
                   ((int) s.charAt(l) < 97 && (int) s.charAt(l) > 57) ||
                   (int) s.charAt(l) < 48) {
                l++;
                continue outer;
            }
            
            while ((int) s.charAt(r) > 122 ||
                   ((int) s.charAt(r) < 97 && (int) s.charAt(r) > 57) ||
                   (int) s.charAt(r) < 48) {
                r--;
                continue outer;
            }
            
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else
                return false;
        }
        
        return check;
    }
}