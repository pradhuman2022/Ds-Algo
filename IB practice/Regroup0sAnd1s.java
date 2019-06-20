public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final String A) {
      
        int value     = 0  ;
        int countOne  = 0 ;
        for(int i = 0 ; i < A.length() ; i++)
        {
            
            if(A.charAt(i) == '1')
            {
                countOne++ ;
                value += i ;
            }
        }
       
       int tempOne1 = countOne ; 
       int tempOne2 = countOne ;
       int value1 = 0 ;
       for(int i =0 ; i < A.length(); i++)
       {
           if(tempOne1 != 0)
            {
                value1 += i ;
                tempOne1-- ;
            }
       }
       int value2 = 0 ;
       int j = A.length() - 1;     
       int k = 0; 
       while(k < countOne)
       {
           value2 += j ; 
           j-- ;
           k++ ;
       }
        
        return Math.min(Math.abs(value - value2), Math.abs(value - value1)) ;
     
    }
}
