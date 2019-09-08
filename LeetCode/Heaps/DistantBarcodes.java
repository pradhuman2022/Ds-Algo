class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
       
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int n = barcodes.length;
        for(int i = 0 ; i < n ;i++)
            hm.put(barcodes[i], hm.getOrDefault(barcodes[i], 0) + 1);
        barcodes = null ;
        Queue<pair>pq = addPairs(hm) ;
        hm = null ;
        int ans[] = new int[n] ;
        int i = 0  ; 
        System.gc();
        while(pq.size()>= 2)
        {
            pair p = pq.poll() ;
            ans[i++] = p.value ; 
            pair p1 = pq.poll() ;
            ans[i++] = p1.value;
            if(--p.count > 0)
                pq.offer(p) ;
            if(--p1.count > 0)
                pq.offer(p1) ;
            
        }
        if(pq.size() > 0)
            ans[i] = pq.poll().value;
        return ans ; 
    }
    
    Queue<pair> addPairs(HashMap<Integer,Integer> hm)
    {
        Queue<pair> pq = new PriorityQueue<pair>((a, b)-> b.count == a.count ? b.value - a.value : b.count - a.count) ; 
        
        for(Map.Entry<Integer,Integer> k : hm.entrySet())
        {
            pq.add(new pair(k.getKey(), k.getValue())) ;
        }
       return pq ;
    }
    
    static class pair
    {
        int count ; 
        int value ; 
        pair(int value, int count)
        {
            this.value = value ;
            this.count = count ;
        }
        
        
    }
    
}
