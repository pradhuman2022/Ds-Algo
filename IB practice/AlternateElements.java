public class Solution {
    public int[] solve(int[] A) {
   
        int required = 1 ; 
         
        if(A[0] >= 0)
        {
            int j = 0 ;
            while(j < A.length - 1 && A[j] >= 0)
            {
                j++ ;
            }
            if(A[j] > 0)
             return A ;
            
            int last = A[0] ;
            int temp = A[j] ;
            
            for(int k = 1 ; k <= j ; k++)
            {
                int t = A[k] ;
                A[k] = last ; 
                last = t ;
            }
            A[0] = temp ;
        }
            
         for(int i = 1 ; i < A.length; i++)
         {
            if(required == 1) // 1 for +ve
             {
                    if(A[i] < 0)
                    {
                         int j = i ; 
                         while(j < A.length - 1 && A[j] < 0)
                         {
                             j++ ; 
                         }
                         if(A[j] < 0) 
                           return A;
                         int last = A[i] ;
                         int temp = A[j] ;
                         for(int k = i + 1 ; k <= j ; k++)
                         {
                             int t = A[k] ;
                              A[k] = last ;
                              last = t ; 
                         }
                         A[i] = temp ;
                    }
                    required = 0 ; 
             }else 
               {
                   if(A[i] >= 0)
                    {
                        int j = i ; 
                        while(j < A.length - 1 && A[j] >= 0)
                        {
                            j++ ;
                        }
                        if(A[j] > 0)
                         return A ;
                        
                        int last = A[i] ;
                        int temp = A[j] ;
                        for(int k = i + 1 ; k <= j ; k++)
                        {
                            int t = A[k] ;
                            A[k] = last ; 
                            last = t ;
                        }
                        A[i] = temp ;
                    }
                    required = 1 ; 
                   
               }
         }
             
         return A ;
   
     
    }
}
