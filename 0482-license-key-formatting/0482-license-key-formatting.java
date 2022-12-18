class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String chars = s.replace("-", "").toUpperCase();
        
        if (chars.length() == 0)
            return sb.toString();

        int start;
        // first group
        if (chars.length() % k == 0) {
            for (int i = 0; i < k; i++)
                sb.append(String.valueOf(chars.charAt(i)));
            start = k;    
        } else {
            for (int i = 0; i < chars.length() % k; i++)
                sb.append(String.valueOf(chars.charAt(i)));
            start = chars.length() % k;
        }
        
        int counter = 0;
        for (int i = start; i < chars.length(); i++) {
            if (counter % k == 0) {
                sb.append("-");
                counter = 0;
            }
            sb.append(String.valueOf(chars.charAt(i)));
            counter++;
        }

        return sb.toString();
    }
}