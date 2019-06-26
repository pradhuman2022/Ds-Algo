public class Solution {
    public int[] subUnsort(int[] A) {
       int i = 0 ;
       int j = A.length - 1 ;

       while(i < A.length - 1 && A[i] <= A[i + 1])
        i++ ;
       while(j > 0 && A[j] >= A[j - 1])
        j-- ;
        if(i == A.length - 1)
         return new int[]{-1} ;
       int max = A[i + 1] ;
       int min = A[i + 1] ;
       for(int l = i ; l <= j ; l++)
       {
           max = Math.max(A[l], max) ;
           min = Math.min(A[l], min) ;
       }
    int l = 0, r = A.length - 1;
	while(A[l] <= min && l <= i){
	   	l++;
	}
	
	while(A[r] >= max && r >= j){
		r--;
	}
        return new int[]{l, r} ;
    }
}
