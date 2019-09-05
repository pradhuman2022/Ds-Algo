import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
     
        HashMap<Integer, Integer> m = new HashMap<Integer,Integer>();
        
     for(int i = 0; i < nums.length; i++)
         {
    m.put(nums[i],m.getOrDefault(nums[i], 0)+ 1);
    }
        Queue<pair> pq =  new PriorityQueue<pair>((a,b)-> a.value - b.value);
   
 for(Map.Entry<Integer,Integer> m1: m.entrySet())
     {
       pair p = new pair(m1.getKey(), m1.getValue());
     
        if(pq.size() == k)
            {
               if(pq.peek().value < p.value)
       {
        pq.poll();
        pq.offer(p);
       }
                   
    }else{
            pq.offer(p);
            }
     
}
        while(!pq.isEmpty())
            {
             ans.add(pq.poll().num);
            }
        //Collections.
        return ans;
   
}
    static class pair{
          int num;
          int value ;
        pair(int n ,  int v)
            {
              num = n;
              value = v;
            }
        }
    
}
