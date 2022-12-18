class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((int) c >= 91 || (int) c < 65)
                sb.append(c);
            else
                sb.append((char) (c + 32));
        }
        return sb.toString();
    }
}