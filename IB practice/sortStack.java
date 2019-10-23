public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> st) {
        
        Stack<Integer> sortedStack = new Stack<Integer> () ;
        
        for(int i = 0 ; i < st.size() ; i++){
            insert_Into_Stack(st.get(i), sortedStack) ;
        }
        return new ArrayList<Integer>(sortedStack) ;
    }
    
    public void insert_Into_Stack(int val , Stack<Integer> sortedStack){
          
          if(sortedStack.isEmpty() || sortedStack.peek() <= val){
              sortedStack.push(val) ; 
              return ;
          }
          
          int top = sortedStack.pop(); 
          
          insert_Into_Stack(val, sortedStack) ;
          
          sortedStack.push(top) ; 
        
    }
}
A
