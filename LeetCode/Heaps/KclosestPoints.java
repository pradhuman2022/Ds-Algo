import java.util.* ;
class Solution {
    public int[][] kClosest(int[][] points, int K) {
         
        return MaxHeap_Kpoints(points, K) ;
    }
    
      public int[][] MaxHeap_Kpoints(int[][]points, int k)
      {
          
          MaxHeap mh = new MaxHeap(k) ;
          for(int i =0 ; i < k ; i++)
          {
            int p1 = points[i][0] ;
            int p2 = points[i][1] ;
            int d = (p1 * p1) + (p2 * p2) ;
            Pair p = new Pair(i, d) ;
             mh.insertKey(p) ; 
          }
          
          for(int i = k  ; i < points.length; i++)
          {
            int p1 = points[i][0] ;
            int p2 = points[i][1] ;
            int d = (p1 * p1) + (p2 * p2) ;
            Pair p = new Pair(i, d) ;
           // System.out.println(p.dist+" "+mh.arr[1].dist) ;
            if(p.dist < mh.arr[0].dist)
            {
                //System.out.println(p.dist+" "+mh.arr[0].dist) ;
                mh.arr[0] = p ; 
                mh.heapify(0);
            } 
          }
          
          int ans[][]= new int[k][2] ; 
          for(int i = 0 ; i < k ; i++)
          {
              ans[i][0] = points[mh.arr[i].index][0];
              ans[i][1] = points[mh.arr[i].index][1];
          }
          return ans; 
          
          
          
      }
      //O(NlogN)
/*      public int[][] bruteForce_KPoints(int [][]points, int K)
      {
         Pair [] p = new Pair[points.length] ; 
        
        for(int i = 0 ; i < points.length; i++)
        {
            int p1 = points[i][0] ;
            int p2 = points[i][1] ;
            double d = Math.sqrt(p1 * p1 + p2 * p2) ;
            p[i] = new Pair(i, d) ;
        }
         Arrays.sort(p, new Comparator<Pair>(){
             public int compare(Pair p1, Pair p2)
             {
                if(p1.dist > p2.dist)
                     return 1 ;
                 else if(p1.dist < p2.dist)
                     return -1 ;
                 else
                     return 0 ;
             }
         });
         int ans[][] = new int[K][2]; 
         for(int i = 0 ; i < K ; i++)
         {
             ans[i][0] = points[p[i].index][0] ;
             ans[i][1] = points[p[i].index][1] ;
         }
        return ans;
                                                     
   }
   */
 static class MaxHeap
    {
       Pair arr[]; 
       int heap_size ;
       int capacity ;
     MaxHeap(int cap)
     {
         heap_size = 0 ;
         capacity = cap ;
         arr = new Pair[cap] ;
     }
     
     int parent(int i)
     {
         return (i - 1) / 2 ;
     }
     
     int left(int i)
     {
         return 2 * i + 1 ;
     }
     
     int right(int i)
     {
         return 2 * i + 2 ;
     }
     
     void swap(int i, int j)
     {
         Pair temp = arr[j];
         arr[j] = arr[i]; 
         arr[i] = temp ; 
     }
     
     void insertKey(Pair key)
     {
         int i = heap_size; 
         arr[heap_size] = key ; 
         heap_size++ ;
         while(i != 0 && arr[i].dist > arr[parent(i)].dist)
         {
             swap(i, parent(i));
             i = parent(i) ;
         }
     }
     
     void heapify(int i)
     {
         int l = left(i) ;
         int r = right(i) ;
         int max = i ;
         
         if(l < heap_size && arr[l].dist > arr[i].dist)
          max = l ; 
         if(r < heap_size && arr[r].dist > arr[max].dist)
             max = r ;
         
         if(max != i)
         {
             swap(max, i);
             heapify(max) ;
         }
         
     }
     
    }
    
  static class Pair{
      int index ; 
      Integer dist ;
      Pair(int index , Integer dist)
      {
          this.index = index ;
          this.dist = dist ;
      }
  }  
}
