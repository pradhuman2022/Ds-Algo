import java.util.* ;
public class Solution {
    public int[] solve(int[] A, int B) {
         Deque <Integer> q = new ArrayDeque<Integer>();
         
         for(int x : A){
             q.offer(x) ;
         }
         
         Queue<Integer> st = new LinkedList<Integer>();
          
          while(B-- > 0){
              st.offer(q.removeFirst());
          }
         while(!st.isEmpty()){
             q.addFirst(st.remove());
         }
         st = null ;
         int i = 0 ; 
         for(; i < A.length ; i++){
             A[i] = q.removeFirst();
         }
         return A ;
    }
}
