import java.util.* ;
import java.math.* ;
import java.util.* ;
public class ContestDiv_2 {
    static int countStrings = 0 ;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        sc.nextLine() ;
        String input = sc.nextLine() ;
     //   mergeSort(input, 0, input.length()) ;
          BigInteger bi= new BigInteger("2") ;  
          BigInteger bi1 = new BigInteger("0") ;  
          for(int r = input.length()  ; r > 0 ; )
        {
            BigInteger m = new BigInteger(input.substring(0, r));
            BigInteger res = m.mod(bi) ;
            
            if(res.equals(bi1))
            {
                countStrings += (r - 1) + 1 ;
              //  l++ ;
            }
           // else
                r-- ;
        }
           System.out.println(countStrings) ;
        
    }
}

 
