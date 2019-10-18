import java.util.* ;
public class Solution {
    public int[] solve(int A) {
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>() ;
        int ans [] = new int[++A] ;
        int i = 0 ;
        pq.add(0L) ;
        while(A-- > 0){
            long val = pq.poll(); 
            long e1 =  1 + val * 10 ;
            long e2 =  2 + val * 10 ; 
            long e3 =  3 + val * 10 ;
            pq.offer(e1) ;
            pq.offer(e2) ;
            pq.offer(e3) ;
            ans[i++] = (int)val ; 
        }
        return Arrays.copyOfRange(ans, 1, ans.length) ;
    }
}
