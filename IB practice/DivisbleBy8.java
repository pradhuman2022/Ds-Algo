import java.math.* ;
public class Solution {
    public int solve(String A) {
        if(A.length() > 3)
      {
        A  = A.substring(A.length() - 3, A.length()) ;
        int a = Integer.parseInt(A) ;
        return a % 8 == 0 ? 1 : 0 ;
      }
      int a = Integer.parseInt(A) ;
      return a % 8 == 0 ? 1 : 0 ;
    }
}
