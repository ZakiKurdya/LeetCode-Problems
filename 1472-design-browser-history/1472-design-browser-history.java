class BrowserHistory {
    private Stack<String> back, forward;
    private String current;
    
    public BrowserHistory(String homepage) {
        back = new Stack<String>();
        forward = new Stack<String>();

        current = homepage;
    }
    
    public void visit(String url) {
        back.push(current);
        current = url;

        forward.clear();
    }
    
    public String back(int steps) {
        while(steps > 0 && !back.empty()) {
            forward.push(current);
            current = back.pop();
            steps--;
        }
        
        return current;
    }
    
    public String forward(int steps) {
        while(steps > 0 && !forward.empty()) {
            back.push(current);
            current = forward.pop();
            steps--;
        }
        
        return current;
    }
}