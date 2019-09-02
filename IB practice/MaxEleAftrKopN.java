import java.util.* ;
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
    
        Queue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2)
            {
                  if(p1.next == p2.next)
                  {
                      return p1.org - p2.org ;
                  }else {
                      return p1.next - p2.next ;
                  }
            }
        }) ;
        
        for(Integer x : A)
        {
            pq.add(new Pair(x, x,x + x)) ;
        }
    
         while(B-- > 0 && !pq.isEmpty()) 
        {
           Pair p = pq.poll() ;
           p.curr = p.next ; 
           p.next = p.curr + p.org ;
           pq.add(p) ;
        }
      
       int ans = Integer.MIN_VALUE ;//return pq.peek().curr ;    
        while(!pq.isEmpty())
        {
            ans = Math.max(ans, pq.poll().curr) ;
        }
        return ans ;
        
    }
    static class Pair
    {
        int org ;
        int next ; 
        int curr ;
        Pair(int org, int curr ,int next)
        {
            this.org = org ;
            this.next = next ;
            this.curr = curr ;
        }
    }
}
