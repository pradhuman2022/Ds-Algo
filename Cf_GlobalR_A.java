import java.util.*;
public class ColorFulWalk {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int arr[] = new int[n] ;
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt() ;
        }
        int preCheck = 1 ;
        int sufCheck = 1 ;
        int r = arr.length - 1 ;
        int l = 0 ;
        while(l < n && arr[l] == arr[r] )
        {
            l++ ;
        }
        preCheck = r - l ;
          r = arr.length - 1 ;
          l = 0 ;
        while( r > 0 && arr[r] == arr[l])
        {
            r-- ;
        }
        sufCheck =  r - l ;
        System.out.println(Math.max(sufCheck, preCheck));
    }
}
