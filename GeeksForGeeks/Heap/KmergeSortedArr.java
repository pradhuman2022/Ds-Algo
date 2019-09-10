class GfG
     {
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
          {
           //add code here.
             Queue<pair> pq = new PriorityQueue<pair>((a, b) -> a.value - b.value) ;
             int size = arrays.length ; 
             size *= size ; 
             for(int i= 0 ; i < arrays.length; i++)
             {
                 pq.add(new pair(i,0 ,arrays[i][0])) ;
             }
             
             
             ArrayList<Integer> ans = new ArrayList<>() ;
             
             while(!pq.isEmpty() && size-- > 0)
             {
                 pair  p = pq.poll()  ;
                 ans.add(p.value); 
                 
                 if(p.col + 1 < arrays.length)
                   pq.add(new pair(p.row, p.col + 1,  arrays[p.row][p.col + 1])) ;
             }
           
           return ans ;
          }
          
        static class pair{
            int row ; 
            int value ;
            int col ; 
            pair(int row, int col , int value)
            {
                this.col = col ; 
                this.row = row ; 
                this.value = value ;
            }
        }  
}
