 import java.util.* ; 
public class Contest
{
   public static void main(String a[])
   {
      Scanner sc = new Scanner(System.in) ;
      int ct1 = sc.nextInt() ; 
      int ct2 = sc.nextInt() ;
      int ct3 = sc.nextInt() ;
      int ct4 = sc.nextInt() ;
     if(ct3 + ct1 == ct3 + ct4)
      {
         if(ct1 > 0 && ct4 > 0 || ct3 == 0)
          
          {
             System.out.println(1) ;
             return ;
          }
      }
 
      System.out.println(0) ;
   }
}
