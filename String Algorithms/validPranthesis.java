class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        if(s.isEmpty())
            return false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '{' || c == '[' || c == '(') {
                st.push(i);
            } else {
                
                if(st.isEmpty()//if no open bracket present
                   || c == '}' && s.charAt(st.peek()) != '{' ||
                   c == ')' && s.charAt(st.peek()) != '(' ||
                   c == ']' && s.charAt(st.peek()) != '[') 
                        return false;
                else 
                    if(!st.isEmpty())
                            st.pop();    
            }
        }
       
        if(!st.isEmpty())
            return false;
        
        return true;
    }
}
