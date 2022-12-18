class MyQueue {
    private Stack<Integer> in, out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        if (!out.isEmpty()) {
            while (!out.isEmpty())
                in.push(out.pop());
        }

        in.push(x);
    }
    
    public int pop() {
        if (!in.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }

        return out.pop();
    }
    
    public int peek() {
        if (!in.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }

        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */