class MyStack {
    Deque<Integer> dq;

    public MyStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.add(x);
    }
    
    public int pop() {
        return dq.pollLast();
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */