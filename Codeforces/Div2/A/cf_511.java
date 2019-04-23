import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
        int n = sc.nextInt() ; 
        int a = 1 ;
        int b = (n % 3) == 0 ? 1 : 2 ; 
        int c = n - (a + b) ;
        System.out.println(a+" "+b+" "+c) ;
    }
  
}
