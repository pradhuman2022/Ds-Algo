class Solution {
    public int calculate(String s) {
        
        Stack<Object> st = new Stack<>();
        s = "(" + s + ")";
        int operand = 0;
        int digits = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                operand = (int) Math.pow(10, digits) * (int) (currentChar - '0') + operand;
                digits += 1;
            } else if (currentChar != ' ') { 
                if (digits != 0) {
                    st.push(operand);
                    operand = 0; 
                    digits = 0;
                }
                
                if(currentChar == '(') {
                    int expressionValue = evaluateExpression(st);
                    st.pop();
                    st.push(expressionValue);
                } else {
                    st.push(currentChar);   
                }
            }
        }
        
        return (int)st.peek();
    }
    
    int evaluateExpression(Stack<Object> st) {
        int res = 0; 
        
        if (!st.isEmpty()) {
            if(st.peek() instanceof Integer) {
                res = (int) st.pop();
            }
        }
        
        while (!st.isEmpty() && (char)st.peek() != ')') {
            char sign = (char)st.pop();
            
            if (sign == '+') {
              res += (int) st.pop();
            } else {
              res -= (int) st.pop();  
            }
        }
        
        return res;
    }
}
