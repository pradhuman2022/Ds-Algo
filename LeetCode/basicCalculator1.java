class Solution {
    
    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<Integer>();
        int currentNumber = 0;
        char currentOperation = '+'; 
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if(Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');    
            } 
            if(!Character.isWhitespace(currentChar) 
                      && !Character.isDigit(currentChar) 
                    || i == s.length() - 1){
                
                if(currentOperation == '+') {
                    st.push(currentNumber);
                }else if(currentOperation == '-') {
                    st.push(-currentNumber);
                }else if(currentOperation == '*') {
                    st.push(st.pop() * currentNumber);
                } else if(currentOperation == '/') {
                    st.push(st.pop() / currentNumber);
                }
                currentOperation = currentChar;
                currentNumber = 0;

            }
        }
        int result = 0; 
        while(!st.isEmpty())
            result += st.pop();
        
        return result;
    }
}
