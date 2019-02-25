import java.util.Scanner;

public class Main {
   
     static int val[] ;
	 static boolean bool = false;
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
      Scanner sc= new Scanner(System.in) ;
      int n = sc.nextInt() ;
      int d = sc.nextInt() ;
     
      
     for(int i = 1 ; i <= 9; i++)
     {
        val=  new int[d] ;
        val[0] = i ;
       if(fValue(n - i , d - 1))
       {
         bool =true ;
         break ;
       }
     }
      if(bool == true)
      {
          String s = " ";
      for(int x : val)
        s += Integer.toString(x) ;
      System.out.print(s.trim()) ;
      }
      else
      {
        System.out.println("unpredictable") ;
      }
	}
  static boolean fValue(int sum , int d)
  {   
       if(sum < 0)
         return false;
       if(sum == 0 && d == 0)
         return true ;
       if(sum == 0 && d != 0)
       {
           for(int i = d ; i > 0;i--)
               val[i] = 0;
           return true ;
       }
       if(sum != 0 && d == 0)
           return false ;
       for(int i = 9 ; i >= 1 ; i--)
       {
         val[d] = i ;
         if(fValue(sum - i, d - 1))
         {
           bool = true ;
           return true ;
         }
       }
    
   return false ; 
  }
}  
