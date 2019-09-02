import java.util.* ; 
public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        Queue <Integer> pq = new PriorityQueue<Integer>();
        for(Integer x : A)
         pq.add(x) ;
        
        int cost = 0 ;
        
        while(pq.size() > 1 && !pq.isEmpty())
        {
            Integer x = pq.poll();
            Integer y = pq.poll() ;
            if(y == null)
              {
                  cost += x ;
                  break ;
              }
            cost += x + y ; 
            pq.add(x + y) ;
        }
        return cost ;
    }
}
