import java.util.* ;
public class Cf_294 {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int n1 = n - 1;
        int n2 = n - 2 ;
        long eCode1 = 0 ;
        long eCode2 = 0 ;
        long sum = 0 ;
        while(n > 0)
        {
           n--;
           sum += sc.nextInt();
        }
        eCode1 = sum ;
        while(n1 > 0)
        {
           n1--;
           eCode1 -= sc.nextInt() ;
        }
        eCode2 = sum - eCode1 ;
        while(n2 > 0)
        {
           n2 --;
           eCode2 -= sc.nextInt();
           
        }
        System.out.println(eCode1);
        System.out.println(eCode2);
        
    }
    
}
