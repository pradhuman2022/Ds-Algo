class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int map[] = new int[1001] ; 
        
        for(int i = 0 ; i < arr1.length ; i++)
        {
            map[arr1[i]]++ ;
        }
        
        int ans[] = new int[arr1.length] ; 
        
        int index = 0 ;
        
        for(int i = 0 ; i < arr2.length;  i++)
        {
              int x = arr2[i] ; 
              int y = map[x]  ;
            for(int k = 1; k <= y ; k++)
            {
                ans[index++] = x  ;
                map[x]-- ;
            }     
        }
        
        for(int l = 0 ; l < 1001 ; l++)
        {
           if(map[l] > 0)
           {
               int x = map[l] ; 
               for(int k = 1; k <= x ; k++)
               {
                   ans[index++] = l ; 
                   map[l]-- ;
               }
           }
        }
     return ans ;    
    }
    
}
