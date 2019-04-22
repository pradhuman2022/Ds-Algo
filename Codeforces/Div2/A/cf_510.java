import java.util.* ;
public class contes
{
   public static void main(String ar[])
   {
      Scanner sc =  new Scanner(System.in) ;
      int n = sc.nextInt() ;
      int m = sc.nextInt() ;
      int max = 0 ;
      int sum = 0 ;
      for(int i = 0 ; i <n ; i++)
         {
            int k = sc.nextInt() ;
            max = Math.max(max, k) ;
            sum += k ;
         }
      int ans2 = m + max ;
      int ans1 = Math.max(max, ((sum + m - 1) / (n)) + 1) ;
      System.out.println(ans1+" "+ans2) ;
   }
}
