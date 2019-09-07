class Solution {
    public List<String> topKFrequent(String[] words, int k) {
           
        HashMap<String, Integer> tm = new HashMap<String, Integer>();
       
        for(int i = 0 ; i < words.length; i++)
            tm.put(words[i], tm.getOrDefault(words[i],0) + 1) ;
         
        Queue<pair> pq = addPairs(tm) ;
        List<String> ans = getFreqNums(pq, k) ;
        pq = null ;
        tm = null;
        return ans ;
    }
    //get ans
    List<String> getFreqNums(Queue<pair> pq, int k)
    {
        ArrayList<String> ans = new ArrayList<String>() ;
        
        while(k-->0 && !pq.isEmpty())
        {
          ans.add(pq.poll().str);    
        }
        return ans ;
    }
    //add pairs to Queue
    Queue<pair> addPairs(HashMap<String, Integer> hm)
    {
        Queue<pair> pq = new PriorityQueue<pair>(new Comparator<pair>(){
            public int compare (pair p1, pair p2)
            {
                if(p1.freq != p2.freq)
                    return p2.freq - p1.freq ;
                else
                    return p1.str.compareTo(p2.str);
            }
        });
            
        for(Map.Entry<String , Integer> m : hm.entrySet())
        {
            pair p = new pair(m.getKey(), m.getValue());
            pq.add(p) ;
        }
        hm = null;
        return pq; 
    }
    static class pair
    {
        String str;
        int freq;
        pair(String s , int f)
        {
            str = s ; 
            freq = f ;
        }
    }
}
