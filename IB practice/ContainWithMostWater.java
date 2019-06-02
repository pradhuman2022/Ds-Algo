public class Solution {
    public int maxArea(int[] A) {
        int left  = 0 ;
        int right = A.length - 1 ;
        if(A.length > 1)
        {
        int currentArea = Math.min(A[left], A[right]) * (right - left) ;
        while(left < right)
        {
           int min = Math.min(A[left], A[right]) ;
           currentArea = Math.max(currentArea , (right - left) * min) ;
           if(A[right] == min)
           {
               right-- ;
           }else
           {
               left++;
           }
        }
        return currentArea ;
        }else return  0 ;
    }
}
