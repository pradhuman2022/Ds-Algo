class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Pair> pq = new PriorityQueue<Pair>((a, b)-> b.value - a.value) ;
        Pair[] p = new Pair[nums.length] ;  
        for(int i = 0 ; i < k; i++)
        {
                Pair p1 = new Pair(nums[i], i) ;
                pq.offer(p1) ;
                p[i] = p1  ;
        }
        int ans[] = new int[nums.length - k + 1] ;
        
        if(nums.length == 0)
             return new int[0] ;
        ans[0] = pq.peek().value ;
       
        for(int i = k, j = 1; i < nums.length  ;i++, j++)
        {
             pq.remove(p[i - k]) ;
             Pair p1 = new Pair(nums[i], i) ;
             pq.offer(p1) ;
             p[i] = p1  ;
             ans[j] = pq.peek().value ;
             System.out.println(pq.peek().value+" "+nums[i]) ;
            
        }
             return ans ;
        
        
    }
    static class Pair
    {
        int value ;
        int index ;
        Pair(int value, int index)
        {
            this.value = value ;
            this.index = index ;
        }
    }
}
