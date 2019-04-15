import java.util.*;
public class Technogoblet {
    public static void main(String ar[])
    {
      Scanner sc = new Scanner(System.in) ;
      int n = sc.nextInt() ;
      int m = sc.nextInt() ;
      int k = sc.nextInt() ;
      int pow[] = new int[n] ;
      int mp [] = new int[m + 1] ;
      int s[] = new int[n] ;
      for(int i = 0; i < n ; i++)
          pow[i] = sc.nextInt() ;
      for(int i = 0 ; i < n ; i++)
      {
          s[i] = sc.nextInt() ;
          mp[s[i]] = Math.max(mp[s[i]],pow[i]) ;
      }
      int ans = 0 ;
      for(int k1 = 1 ; k1 <= k; k1++)
      {
          int c = sc.nextInt() ;
          if(pow[c - 1] != mp[s[c - 1]])
              ans++ ;
      }
      System.out.println(ans) ;
      
    }
}
