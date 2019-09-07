class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
   if(nums1.length == 0 || nums2.length == 0 || k == 0)
        return ans ;
        
    int visited[][] = new int[nums1.length][nums2.length] ;    
    Queue<pair> pq = new PriorityQueue<pair>((a, b)-> a.sum - b.sum); 
     pq.add(new pair(0,0,nums1[0] + nums2[0]));  
      while(!pq.isEmpty() && k--> 0)
      {
       
          pair p = pq.poll();
          ArrayList<Integer> al = new ArrayList<Integer>();
          al.add(nums1[p.i]);
          al.add(nums2[p.j]);
          ans.add(al);
          
        if(p.i + 1 < nums1.length && visited[p.i + 1][p.j] == 0)
        {
            pq.add(new pair(p.i + 1, p.j, nums1[p.i + 1] + nums2[p.j]));
            visited[p.i + 1][p.j] = 1 ;
        }
        if(p.j + 1 < nums2.length && visited[p.i][p.j + 1] == 0)
        {
            pq.add(new pair(p.i, p.j + 1, nums1[p.i] + nums2[p.j + 1]));
            visited[p.i][p.j + 1] = 1 ;
        }  
      }
           
        return ans ;
    }
    static class pair{
        int i ;
        int j ; 
        int sum ;
        pair(int i, int j, int sum)
        {
            this.i = i ; 
            this.j = j ;
            this.sum = sum ;
        }
    }
 
}
