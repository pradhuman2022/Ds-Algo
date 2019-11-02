import java.util.* ;

class Solution {
    Stack <Integer> st = new Stack<Integer>() ;
    int currMin = -1; 
    public void push(int x) {
        
        if(st.isEmpty())
         {
             currMin = x  ;
             st.push(x) ;
         }else{ 
             if(x <= currMin){
                 st.push(2 * x - currMin); 
                 currMin = x ; 
             }else
               st.push(x) ;
         }
    }

    public void pop() {
        
        
              if(!st.isEmpty())    
               {
                   int val  = currMin ;
                   if(st.peek() < currMin)
                     currMin = 2 * currMin - st.peek()  ;
                   st.pop();
                   if(st.isEmpty())
                     currMin = -1 ;
                   return ; 
               }
               currMin = -1 ;
    }

    public int top() {
        if(st.isEmpty())
          return -1 ; 
        else
          {
              if(st.peek() <= currMin)
                return currMin ;
              else
                return st.peek() ;
          }
    }

    public int getMin() {
        return currMin ;
    }
}
