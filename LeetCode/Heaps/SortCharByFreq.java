class Solution {
    public String frequencySort(String s) {
        HashMap<Integer,Integer> tm = new HashMap<Integer,Integer>() ;
        for(int i = 0 ; i < s.length(); i++)
        {
            tm.put((int)s.charAt(i), tm.getOrDefault((int)s.charAt(i), 0) + 1) ;
        }  
         Queue<pair> pq = addPairs(tm) ;
         tm = null ;
         StringBuilder res = new StringBuilder() ;
         while(!pq.isEmpty())
         {
             char c = (char)pq.peek().val ;
             int freq = pq.peek().freq  ; 
             pq.poll(); 
             
             for(int i = 1 ; i <= freq; i++)
                 res.append(c) ;
         }
        pq = null ;
        return res.toString();
    }
    
    //addpairs
    Queue<pair> addPairs(HashMap<Integer,Integer> tm)
    {
        Queue<pair> pq = new PriorityQueue<pair>((a, b)-> b.freq - a.freq) ;
           for(Map.Entry<Integer,Integer> me : tm.entrySet())
        {
            pair p = new pair(me.getValue(), me.getKey()) ;
            pq.offer(p) ;
        }
        tm = null ;
        return pq ;
    }
    static class pair{
        int freq;
        int val ;
        pair(int f ,int v)
        {
            this.freq = f; 
            this.val = v ;
        }
        
    }
}
