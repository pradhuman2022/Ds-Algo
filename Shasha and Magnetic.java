import java.util.*;

public class test
{
   public static void main(String arg[])
   {
      Scanner sc = new Scanner(System.in) ;
      int n = sc.nextInt() ;
      int x = 2 ;
      int ar[] = new int[n] ;
      int sum = 0;
      for(int i = 0 ; i < n ; i++)
      {
         ar[i] = sc.nextInt();
         sum += ar[i] ;
      }
      
      Arrays.sort(ar) ;
      int maxIndices  = 1;
      int ans = sum;
      
   for(int j = 1 ; j < n ; j++)
    {
       for(int i = 2 ; i < 100 ; i++)
       {
         if(ar[j] % i == 0)
         ans = Math.min(ans, sum - (ar[0] + ar[j]) + (ar[0] * i) + (ar[j] / i)) ;
       }
    }
      System.out.print(ans) ;
      
   }
   
   
}
