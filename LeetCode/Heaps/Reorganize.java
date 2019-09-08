class Solution {
    public String reorganizeString(String s) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>() ;
        for(int i = 0; i < s.length() ; i++)
        {
            hm.put((int)s.charAt(i), hm.getOrDefault((int)s.charAt(i),0) + 1) ;
        }
        
        Queue<pair> pq = addPairs(hm) ;
        hm = null ;
        StringBuilder ans = new StringBuilder() ;
        int n = s.length() ;
        s = null ;
        System.gc() ;
        while(pq.size() >= 2)
        {
            pair p = pq.poll() ;
            pair p1 = pq.poll() ;
            if(p.count > (n + 1) / 2 || p1.count > (n + 1)/ 2)
              return "" ;            
            ans.append((char)p.ch)  ;
            ans.append((char)p1.ch) ;
            if(--p.count > 0)    
              pq.add(p) ; 
            if(--p1.count > 0)
               pq.add(p1) ;
        }
        
        if(pq.size() > 0)
        {
            if(pq.peek().count <= (n + 1) / 2)
              ans.append((char)pq.poll().ch) ;
        }
        return ans.toString() ;
    }
    
    
        Queue<pair> addPairs(HashMap<Integer, Integer> hm)
        {
           Queue<pair> pq = new PriorityQueue<pair>((a,b)-> b.count - a.count) ;
              
           for(Map.Entry<Integer, Integer> m : hm.entrySet())
           {
               pq.add(new pair(m.getValue(), m.getKey())) ;  
           }
           return pq ;   
        } 
    
     static class pair
     {
        int count ;
        int ch ; 
        pair(int count, int ch)
        {
            this.count = count ;
            this.ch = ch ;
        }
     }
}
