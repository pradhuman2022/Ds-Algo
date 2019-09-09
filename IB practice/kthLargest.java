                                                            
import java.util.* ;
public class Solution {
    public int[] solve(int A, int[] B) {
           
       Queue<Integer> pq = new PriorityQueue<Integer>((a, b)-> a - b) ;
       int ans[] = new int[B.length] ; 
       for(int i = 0 ; i < A  - 1; i++)
       {
           ans[i] = -1 ; 
           pq.add(B[i]) ;
       }
       pq.add(B[A - 1]) ;
       ans[A - 1] =pq.peek() ; 
       for(int i = A ; i < B.length; i++)
       {
            
            if(B[i] > pq.peek())
            {
                pq.poll() ; 
                pq.add(B[i]) ; 
                ans[i] = pq.peek() ; 
            }else
            {
                ans[i] = pq.peek() ; 
            }
       }
       return ans ;
    }
}
