import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
      
        ArrayList<BuildingPoint> bps = new ArrayList<BuildingPoint>() ;
        for(int a[]: buildings)
        {
            int l = a[0] ;
            int r = a[1] ;
            int h = a[2] ;
            BuildingPoint startPoint = new BuildingPoint(l, h , true) ;
            BuildingPoint endPoint = new BuildingPoint(r, h , false) ;
            bps.add(startPoint);
            bps.add(endPoint);
        }
                     
       Collections.sort(bps, new Comparator<BuildingPoint>(){
           public int compare(BuildingPoint b1, BuildingPoint b2) 
           {
               if(b1.x != b2.x)
                   return b1.x - b2.x ;
               else
               {
                    
                         return (b1.p_type ? -b1.y : b1.y) - (b2.p_type ? -b2.y : b2.y)  ;
               } 
           }
       }) ;
        
        for(BuildingPoint p : bps)
         System.out.println(p.x+" "+p.y+" "+p.p_type) ;
        int prevMaxHeight = 0 ;
        List<List<Integer>> ans = new ArrayList<List<Integer>>() ;
        TreeMap <Integer, Integer> pq = new TreeMap<Integer, Integer>() ;
        pq.put(0, 1) ;
        for(BuildingPoint b : bps)
        {
            if(b.p_type == true)
            {

                 pq.put(b.y, pq.getOrDefault(b.y, 0) + 1) ;
            }
            else 
            {
                  int k = pq.getOrDefault(b.y, 0) ;
                  if(k == 1)
                      pq.remove(b.y) ;
                  else 
                      pq.put(b.y, k -1) ;
                System.out.println(k) ;
                  
            }
            int currMaxHeight = pq.lastKey() ; 
            if(currMaxHeight != prevMaxHeight)
            {
            ArrayList<Integer> b1 = new ArrayList<Integer>() ;
             b1.add(b.x) ; 
             b1.add(currMaxHeight) ; 
             ans.add(b1) ;
             prevMaxHeight = currMaxHeight ;
            }
            //return ans ;
        }
        
        Collections.sort(ans, (a1, b1)-> a1.get(0) - b1.get(0)) ;
        return ans ;
    }
    
    static class BuildingPoint
    {
        int x ; 
        int y ;
        boolean p_type ;
        BuildingPoint(int x, int y , boolean type)
        {
            this.x = x ;
            this.y = y ;
            this.p_type = type ;
        }
        
    }
    
}
