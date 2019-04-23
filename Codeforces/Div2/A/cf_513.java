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
      for(int i = 0 ; i < n; i++)
      {
          if(s.charAt(i) -'0'== 8)
              count++ ;
                  
      }
      int ans = 0 ;
      for(int i = 1 ; i <= count; i++)
      {
          if(n - 11 >= 0)
              ans++ ;
          n -= 11 ;
      }
      System.out.println(ans) ;
    }
  
}
