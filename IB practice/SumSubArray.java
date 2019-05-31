public class Solution {
    public int[] solve(int[] A, int B) {
        int sum = A[0] + A[1] ;
        int i = 0 , j = 1;
        boolean t = false ;
        
        while(i < A.length && j < A.length)
        {
            if(sum == B)
            {
                t = true ;
                break ;
            }
            else if(sum > B)
             {
                 sum = sum - A[i] ;
                 i++ ;
             }
            else 
             {
                  j++ ;
                 if(j < A.length)sum = sum + A[j] ;
                
             }
        }
        if(!t)
        {
           return new int[]{-1} ;
        }
        else
        {
        int size = j - i + 1 ;
        int output[] = new int[size] ; 
        for(int l = 0 , k = i ; l < size && k <= j ; k++, l++)
        {
            output[l] = A[k] ; 
        }
        return output;
        }
    }
}
