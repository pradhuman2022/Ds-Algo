import java.util.* ;

public class Solution {
    public int solve(int[] A) {
     
     Stack<Integer> c = new Stack<Integer>() ; 
     Stack<Integer> b = new Stack<Integer>() ; 
     /*
       we should think like that all values in C in asceding order top to bottom .
     */
     
     for(int i = 0 ; i < A.length ; i++){
         
         if(c.isEmpty()){
             c.push(A[i]) ; 
             // if middleware stack is empty . 
         }else{
              // if value is less than peek value of c stack then only push  into c stack
              if(!c.isEmpty() && c.peek() >= A[i])
                c.push(A[i]);
               else{
                    
                    while(!c.isEmpty() && c.peek() < A[i]){
                        if(!b.isEmpty() && c.peek() < b.peek())
                          return 0 ; 
                        b.push(c.pop()) ;  
                    }
                    c.push(A[i]) ;
               }    
         }
         
     }
        
        while(!c.isEmpty() && (b.isEmpty() || b.peek() <= c.peek())){
            b.push(c.pop()) ;
        }
        
     
       // if c is empty then everything is fine 
       if(c.isEmpty())
         return 1 ; 
        else
          return 0 ; 
        
        
    }
}
