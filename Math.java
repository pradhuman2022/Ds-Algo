import java.util.*;
public class RearrangeString {
    
   
 
   public static void main(String arg[])
   {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int op = 0, mu = 0;
      if(n == 1)
      {
         System.out.println(n+" "+0);
      }
      else
      {
      while(isAInt(n))
      {
         n = (int)Math.sqrt(n) ;
         op++;
      }
     
      for(int i = (int)Math.sqrt(n) ; i > 1 ; i--)
      {
         while(n %(i * i) == 0)
         {
            n = n / i ;
            mu = 1 ;
            op++ ;
         }
      }
      System.out.print(n+" "+(op+mu));
      }   
   }    
         
         
        static boolean isAInt(int n)
    {
        int n1 = (int)Math.sqrt(n) ;
        return n == n1 * n1;   
    }    
}
