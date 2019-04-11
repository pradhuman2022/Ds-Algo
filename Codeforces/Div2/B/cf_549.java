import java.util.* ;
public class Cf_549 {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int prod = 1 ;
        int len = 0 ;
        int temp = n ;
       
        if(n < 10 && n >= 1)
         {
            System.out.println(n) ;
             return ;
         }    

        System.out.print(getProd(n)) ;
    }
   static long getProd(int n)
    {
       if(n < 10)
        return Math.max(1, n) ;
       return Math.max(getProd((n / 10)) * (n % 10) , getProd((n/10) - 1) * 9);
    }
    
}
