class Solution {
    public String reverseWords(String s) {
        Stack<String> reverse = new Stack<>();
        for (String str : s.trim().split(" "))
            if (str.length() > 0)
              reverse.push(str);
    
        StringBuilder sb = new StringBuilder();
        while (!reverse.isEmpty())
            sb.append(reverse.pop()).append(" ");

        return sb.toString().trim();
    }
}