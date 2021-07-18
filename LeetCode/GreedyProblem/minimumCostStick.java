    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < sticks.length; i++)
            pq.add(sticks[i]);
        
        int ans  = 0;
        while(pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            ans += temp;
            pq.add(temp);
        }
        return ans;
    }
}
