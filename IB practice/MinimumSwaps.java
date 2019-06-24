public class Solution {
    public int solve(int[] A, int B) {
        int sm = 0 ;
        int bi = 0 ;
        
        for(int i = 0 ; i < A.length ; i++)
        {
            if(A[i] <= B)
             sm++ ;
        }
        
        for(int i = 0 ; i < sm ; i++)
        {
            if(A[i] > B)
             bi++ ;
        }
         int ans = bi ;
         int sm1 = sm ;
        for(int i = 1 ; i < A.length - sm + 1 ; i++)
        {
             if(A[i - 1] > B)
             {
                 bi-- ;
             }
            if(A[i + sm - 1] > B)
             {
                 bi++;
             }
            ans = Math.min(ans, bi) ;
        }
      return ans ;
      
      
      
      //---------------------------------------------------------------------rough code----------------
      /*
          int less= 0 ;
          int more = 0 ;
          for(int i = 0 ; i < A.length; i++)
          {
              if(A[i] <= B)
               less++ ;
          }
      
         for(int i = 0 ; i < less ; i++)
         {
             if(A[i] > B)
              more++ ; 
         }
         
         int ans = more ;
         int j = less ;
         int i = 0 ;
         while(j < A.length)
         {
             if(A[i] > B)
              more--; 
             if(A[j] > B)
              more++ ;
              j++;
              i++;
              ans = Math.min(ans, more) ;
         }
      return ans ;
      
       
       /*
        int total =0 ; 
        for(int i = 0 ; i < A.length; i++)
        {
            if(A[i] <= B) 
             total++ ;
        }
       
        int leftCount = 0 ;
        int ans = Integer.MAX_VALUE ;
        
        for(int i = 0; i < A.length ; i++)
        {
            if(A[i] <= B)
            {
            int lc = leftCount ;
            int rc = total - leftCount - 1 ;
            int j = i - 1 ;
           
            while(lc > 0 && j >= 0 && A[j] <= B)
            {
             lc = lc - 1 ;
             j--;
            }
            
            j = i + 1 ;

            while(rc > 0 && j <= A.length - 1 && A[j] <= B)
            {
             rc = rc - 1 ;
             j++;
            }
            
            ans = Math.min(ans, lc+rc) ; 
            leftCount++ ;
            }
        }
        
        return ans ;*/
        
    }
}
