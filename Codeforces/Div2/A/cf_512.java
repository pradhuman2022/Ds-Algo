import java.util.* ;
public class Contest
{
   public static void main(String arg[])
   {
      Scanner sc = new Scanner(System.in) ;
      int n = sc.nextInt() ;
      int sum = 0 ;
      while(n-- > 0)
      {
         sum += sc.nextInt() ;
      }
      if(sum > 0)
       System.out.println("HARD") ;
       else
       System.out.println("EASY") ;
   }
}
