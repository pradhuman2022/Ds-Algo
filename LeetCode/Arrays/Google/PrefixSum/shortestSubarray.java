class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        
        long p[] = new long[n + 1];
        
        for (int i = 1; i <= n; i++) 
            p[i] = p[i - 1] + nums[i - 1];
        
        int ans = n + 1;
        Deque<Integer> monoq = new LinkedList();
        
        for (int i = 0; i < p.length; i++) {
            
            while(!monoq.isEmpty()  && p[i] <= p[monoq.getLast()])
                monoq.removeLast();
            
            while(!monoq.isEmpty() && p[i] >= p[monoq.getFirst()] + k)
                ans = Math.min(ans, i - monoq.removeFirst());
            
            monoq.addLast(i);
        }
        
        return ans == n + 1 ? -1 : ans;
    }
}
