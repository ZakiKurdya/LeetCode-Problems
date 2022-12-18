class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> temp = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!temp.isEmpty() && temp.peek() == c)
                temp.pop();
            else
                temp.push(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : temp)
            result.append(c);
        
        return result.toString();
    }
}