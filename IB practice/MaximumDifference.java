import java.util.* ;
public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A) ;
        int s1 = 0 ;
        int s2 = 0 ;
        int n = A.length ;
        
        if(B == n)
        {
            int sum = 0;
            for(int x : A)
            sum += x ;
            return sum ;
        }
        
        if(B < (n / 2))
        {
            for(int i = 0 ; i < B ; i++)
            {
                s1 += A[i] ;
            }
            
            for(int i = B ; i < n; i++)
            {
                s2 += A[i] ;
            }
            
            return s1 > s2 ? s1 - s2 : s2 - s1 ;
            
        }else if(B == n / 2)
        {
            for(int i = 0 ; i <= (n / 2) - 1 ; i++)
            {
                s1 += A[i];
            }
            
            for(int i = (n / 2); i < A.length ; i++)
            {
                s2 += A[i] ; 
            }
            return s1 > s2 ? s1 - s2 : s2 - s1 ;
            
        }
        else
        {
            for(int i = n - B ; i < A.length ; i++)
            {
                s1 += A[i] ;
            }
            for(int i = 0 ; i < n - B ; i++)
            {
                s2 += A[i] ;//000000000000000000000000000000000
            }
            
            return s1 > s2 ? s1 - s2 : s2 - s1 ;
        }
        
        
        
    }
}
