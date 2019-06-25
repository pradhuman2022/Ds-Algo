public class Solution {
    public int maxArea(int[] A) {
        int i = 0 ;
        int j = A.length - 1 ;
        
        int currentMax = Integer.MIN_VALUE ;
        if(A.length == 1)
         return 0 ;
        while(i < j)
        {
            int min = Math.min(A[i], A[j]) ;
            
            int area = min * (j - i) ;
            
            if(min == A[i])
            {
                i++; 
            }else
            {
                j-- ;
            }
            currentMax = Math.max(area, currentMax) ;
        }
        return currentMax ;
    }
}
