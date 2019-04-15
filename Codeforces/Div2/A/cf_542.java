import java.util.*;
public class BePositive {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int arr[] = new int[n] ;
        int countPositive = 0 ;
        int countNegative = 0 ;
        int countZero = 0 ;
        for(int i = 0 ; i < n ;i++)
        {
            arr[i] = sc.nextInt() ;
            if(arr[i] == 0)
                continue ;
            if(Math.signum(arr[i]) == 1)
                countPositive++;
            else if(Math.signum(arr[i] )== -1)
                countNegative++;
           
        }
       //System.out.println(Math.floor(n -(n / 2))) ;
       if(countPositive >= (int)Math.floor(n - (n / 2)))
           System.out.println(1);
       else if(countNegative >= (int)Math.floor(n - (n / 2)))
           System.out.println(-1) ;
       else
        System.out.println(0) ;
      
         
    }
}
