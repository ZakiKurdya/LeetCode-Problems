class Solution {
    public String removeStars(String s) {
        Stack<Character> temp = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '*')
                temp.pop();
            else
                temp.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!temp.isEmpty())
            sb.append(temp.pop());
        
        return sb.reverse().toString();
    }
}