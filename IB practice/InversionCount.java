public class Solution {
    static int invCount = 0 ;
    static int mod = (int)Math.pow(10, 9) + 7 ;
    public int solve(int[] A) {
         mergeSort(0, A.length - 1, A);
        int ans = invCount ;
        invCount = 0 ;
        return ans ;
    }
   static  void mergeSort(int start , int end, int A[])
    {
        if(start >= end)
          return ; 
        int mid = (start+ end) / 2 ;
        mergeSort(start, mid , A) ;
        mergeSort(mid + 1, end , A) ;
        merge(start, end , mid, A) ;
    }
    
   static void merge(int start , int end, int mid , int A[])
    {
        int L[] = new int[mid - start + 1] ;
        int R[] = new int[end - mid] ;
        
        for(int i= 0 ; i < L.length ; i++)
        {
            L[i] = A[i + start] ;
        }
        
        for(int j = 0 ; j < R.length ; j++)
        {
            R[j] = A[mid + 1 + j] ;
        }
        
        int i = 0 ; 
        int j = 0 ;
        int k = start ;
        while(i < L.length && j < R.length)
        {
            if(L[i] > R[j])
            {
                invCount = (invCount + (L.length - i))% mod ;
                A[k++] = R[j++] ;
            }else
            {
                A[k++] = L[i++];
            }
        }
        
        while(i < L.length)
        {
            A[k++] = L[i++] ;
        }
        
        while(j < R.length)
        {
            A[k++] = R[j++] ;
        }
        
    }
}
