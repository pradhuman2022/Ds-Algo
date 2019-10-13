/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
         int n = 3 ;//sc.nextInt() ;
         //sc.nextLine() ;
         String s = "110";//sc.nextLine();
         int ansFromLeft = n ;
         for(int i = 1 ; i <= n ; i++){
             if(s.charAt(i - 1) - '0' == 1){
               int option1 = 2 *((i - 1) + 1) ;
               int option2 = ((n - i) + 1)+((i - 1) + 1) ;
               ansFromLeft = Math.max(ansFromLeft, Math.max(option1, option2)); 
             }
         }
         int ansFromRight = n ;
          for(int i = n ; i >= 1 ; i--){
             if(s.charAt(i - 1) - '0' == 1){
               int option1 = 2 *((n - i) + 1) ;
               int option2 = ((n - i) + 1)+((i - 1) + 1) ;
               ansFromRight = Math.max(ansFromRight, Math.max(option1, option2)); 
             }
         }
         
         System.out.println(Math.max(ansFromRight,ansFromLeft));
        //System.out.println(Math.max(Math.max(ans1, ans2), Math.max(ans3, ans4)));
      
	}
}
