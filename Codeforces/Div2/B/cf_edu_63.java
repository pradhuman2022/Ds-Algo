import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
      int n = sc.nextInt() ; 
      sc.nextLine();
      String s = sc.nextLine() ;
      int count = 0;
      int chances = (n - 11) / 2 ;
      for(int i = 0 ; i < n - 10; i++)
      {
          if(s.charAt(i) -'0'== 8)
              count++ ;
                  
      }
        System.out.println(chances < count ? "YES" :"NO") ;
    }
  
}
