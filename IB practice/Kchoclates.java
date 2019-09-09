import java.util.* ;
public class Solution {
    public int nchoc(int A, int[] B) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a, b)-> b - a);
        
        for(int i = 0 ; i <B.length ; i++)
        {
            pq.add(B[i]);
        }
        int ans = 0 ;
        int mod = (int)Math.pow(10,9) + 7;
        while(A-- > 0)
        {
            ans = ((ans % mod) + (pq.peek() % mod)) % mod ;
            int p = (int)Math.floor((double)pq.poll() / 2);
            pq.add(p);
        }
        return ans ;
        
    }
}
