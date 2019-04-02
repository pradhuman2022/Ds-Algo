import java.util.* ;
public class ThanosSort {
    static int count = 1 ;
    public static void main(String ar[])
    {
     Scanner sc = new Scanner(System.in) ;
     int n = sc.nextInt() ;
     int arr[] = new int [n] ; 
     for(int i = 0 ; i < n ; i++)
         arr[i] = sc.nextInt() ;
    // mergeSort(arr, 0, arr.length - 1) ;
    //System.out.println(count) ;
    if(n == 1)
      {
         System.out.println(1) ;
         return ;
      }
   int ans = maxLength(arr, 0, arr.length - 1 , 0) ;
    System.out.println(ans) ;
    }
    static boolean isSorted(int arr[], int start , int end)
    {
        for(int i = start ; i < end ;i++)
        {
            if(arr[i] > arr[i+1])
                return false ;
        }
        return true ;
    }
    
    static int maxLength(int arr[], int start , int end , int length)
    {
        if(start >= end)
            return 0 ;
        int mid = (start + end) / 2 ;
        int ans = 1; 
        if(!isSorted(arr, start, end))
        {
        int l = maxLength(arr, start , mid ,length);
        int r = maxLength(arr, mid + 1, end, length) ;
        ans = Math.max(ans, Math.max(l, r)) ;
        }
        else
        {
          ans = end - start + 1 ;
        }
        return ans ;
    }
}
