import java.util.* ;
class Solution {
    public int longestValidParentheses(String s) {
             
        int max = Integer.MIN_VALUE ; 
        
        Stack<Integer> st = new Stack<Integer>() ;
        st.push(-1)  ;
        
        for(int i = 0; i < s.length() ; i++)
        {
            
            if(!st.isEmpty())
            {
                char c = s.charAt(i) ;
                if(c == '(')
                   st.push(i) ; 
                else
                {
                    if(st.peek() == -1)
                    {
                        st.push(i) ;
                        continue ;
                    }
                    if(s.charAt(st.peek()) == '(')
                    {
                        st.pop(); 
                        max = Math.max(max, i - st.peek()) ;
                    }else
                    {
                        st.push(i) ;
                    }
                }
                
                
            }
            
            
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
