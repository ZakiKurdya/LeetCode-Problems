class Solution {
    public int calculate(String s) {
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (char c : s.replace(" ","").toCharArray()) {
            if (c == '-' && (prev == '(' || prev == '-')) {
                sb.append("1-1-");
            } else {
                sb.append(c);     
            }
            prev = c;
        }
        ExpressionTree et = new ExpressionTree();
        ExpressionTree.Node expression = et.buildETWithInfix(sb.toString());
        return (int) et.evaluateExpressions(expression);
    }

    public class ExpressionTree {
    /** Binary Tree Node */
     public static class Node {
        String value;
        Node left, right;
        Node (String value){
            this.value = value;
            left = right = null;
        }
    }

     private void constructNode(Stack<String> operation, Stack<Node> operands) {
        Node root = new Node(operation.pop());
        root.right = operands.pop();
        root.left = operands.pop();
        operands.push(root);
    }

    /** Enter the Arithmetic Expression to be evaluated */
    public Node buildETWithInfix(String expression) {
        Map<Character, Integer> priority = Map.of('(', 1, '+', 2, '-', 2, '*', 3, '/', 3);
        Stack<Node> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        StringBuilder wholeNumber = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                operators.push("(");
            } else if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                while ('0' <= expression.charAt(i) && expression.charAt(i) <= '9'){
                    wholeNumber.append(expression.charAt(i));
                    if ((i+1) < expression.length() && '0' <= expression.charAt(i+1) && expression.charAt(i+1) <= '9')
                        i++;
                    else break;
                }
                Node node = new Node(wholeNumber.toString());
                wholeNumber = new StringBuilder();
                operands.push(node);
            } else if (expression.charAt(i) == ')') {
                while (!operators.peek().equals("("))
                    constructNode(operators, operands);
                operators.pop();
            } else {
                while (!operators.empty() && priority.get(operators.peek().charAt(0)) >= priority.get(expression.charAt(i)))
                    constructNode(operators, operands);
                operators.push(String.valueOf(expression.charAt(i)));
            }
        }

        while (operands.size() > 1)
            constructNode(operators, operands);
        return operands.peek();
    }

    private boolean isExternal(Node node){
        return node.left == null && node.right == null;
    }

    /** Evaluate the Arithmetic Expressions using Binary Tree */
    public double evaluateExpressions(Node root){
        if (root == null)
            return 0;
        else {
            if (isExternal(root))
                return Integer.parseInt(root.value);
            else {
                double x = Double.parseDouble(String.valueOf(evaluateExpressions(root.left)));
                double y = Double.parseDouble(String.valueOf(evaluateExpressions(root.right)));
                String operator = root.value;
                switch (operator){
                    case "*" -> {
                        return x*y;
                    }
                    case "/" -> {
                        return x/y;
                    }
                    case "+" -> {
                        return x+y;
                    }
                    case "-" -> {
                        return x-y;
                    }
                    default -> {
                        return 0;
                    }
                }
            }
        }
    }
}
}