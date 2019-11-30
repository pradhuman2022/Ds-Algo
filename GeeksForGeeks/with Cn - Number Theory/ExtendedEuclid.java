/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		Triplets ans = extendedEuclid(27, 12) ; 
		System.out.println(ans.gcd+" "+ans.x+" "+ans.y);
	}
  static Triplets extendedEuclid(int a, int b){
       // base case 
       if(b == 0)
        {
            Triplets ans = new Triplets() ;
            ans.gcd = a ; 
            ans.x = 1 ;
            ans.y = 0 ; 
            return ans ; 
        }
        Triplets nextAns = extendedEuclid(b , a % b) ;
        Triplets ans = new Triplets() ;
        ans.gcd = nextAns.gcd ;
        ans.x = nextAns.y ; 
        ans.y = nextAns.x - (a / b) * nextAns.y ; 
        return ans ;
   }
  static class Triplets{
       int gcd ;
       int x; 
       int y ;
   }	 
}
