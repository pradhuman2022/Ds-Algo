import java.util.*;
public class Div
{
   public static void main(String s[])
   {
      
      Scanner sc = new Scanner(System.in) ;
      
      int T = sc.nextInt() ;
      while( T > 0)
      {
         int l = sc.nextInt() ;
         int r = sc.nextInt() ;
         printPair(l , r) ;
         T--;
      }
   }
   static void printPair(int l , int r)
   {
       int maxRange = r ;
       while(l <= r)
       {
       int mid = (l + r) / 2 ;
       
       if(2 * mid <= maxRange)
       {
          System.out.println(mid+" "+(2 * mid));
         break ;
       }
     
  
        r = mid - 1 ;
      }
      
   }
   
}
