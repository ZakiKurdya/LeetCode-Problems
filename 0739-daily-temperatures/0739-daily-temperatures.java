class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        result[n - 1] = 0;
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[stack.peek()])
                result[i] = stack.peek() - i;
            else {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                    stack.pop();
                if (stack.isEmpty())
                    result[i] = 0;
                else
                    result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}