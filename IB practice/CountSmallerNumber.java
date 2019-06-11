public class Solution {
    public int[] solve(int[] A) {
     
     int n = A.length ; 
     Pair[] p = new Pair[n] ;
     for(int i = 0 ; i < n ; i++)
     {
         p[i] = new Pair(A[i], i , 0) ;
     }
     mergeSort(0, n - 1, p) ;
     int a[] = new int[n] ;
     
     
     for(int i = 0 ; i < n ; i++)
     {
         a[p[i].index] = p[i].InvCount ;
     }
     
     return a ;
    }
    void mergeSort(int start , int end, Pair p[])
    {
        if(start >= end)
        return ;
            
            int mid = (start + end) / 2 ;
            mergeSort(start, mid , p);
            mergeSort(mid + 1, end, p) ; 
            merge(p ,start, end, mid) ;
    }
        
    void merge(Pair P[], int start, int end, int mid)
    {
       Pair L[] = new Pair[mid - start + 1] ;
       Pair R[] = new Pair[end - mid] ;
       
       for(int i = 0; i < L.length; i++)
       {
           L[i] = P[i + start] ;
       }
        
       for(int i = 0 ; i < R.length; i++)
       {
           R[i] = P[mid + 1 + i] ;
       }
        
       int i = 0 , j = 0;
       int k = start ; 
       int currentSet = 0 ;
       while(i < L.length && j < R.length)
       {
           if(L[i].value > R[j].value)
           {
               currentSet++ ;
               P[k++]= R[j++] ;
           }else
           {
               L[i].InvCount += currentSet ;
               P[k++] = L[i++] ;
           }
       }
       while(i < L.length)
       {
           L[i].InvCount += currentSet ;
           P[k++] = L[i++]  ;
       }
       while(j < R.length)
       {
           P[k++] = R[j++] ;
       }
       
    }
    
    
    
    static class Pair
    {
        int value ; 
        int index ; 
        int InvCount ;
        public Pair(int v, int i ,int invC)
        {
            this.value = v ;
            this.index = i; 
            this.InvCount = invC ;
        }
    }
}
