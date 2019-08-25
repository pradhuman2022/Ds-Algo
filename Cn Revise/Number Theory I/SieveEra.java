import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
           Scanner sc = new Scanner(System.in) ;
           int n = sc.nextInt() ;
          
          System.out.println(sieveEra(n)) ;
           
	}  
             static boolean isPrime(int n)
             {
                 int i = (int)Math.sqrt(n) ;
                 int count = 0;
                 for(int j = 1 ; j <= i; j++)
                 {
                     if(n % j == 0)
                     {
                         if(j * j == n)
                             count += 1 ;
                         else
                             count += 2 ;
                     }
                     
                 }
                 if(count == 2)
                     return true ;
                 return false ;
                 
             }
          static int sieveEra(int n)
          {
              boolean values[] = new boolean[n + 1] ; 
              
              for(int i = 2; i < values.length; i++)
              {
                  values[i] = true ;
              }
              
             for(int i = 2 ; i <= Math.sqrt(n) ; i++)
             {
                   if(!values[i])
                       continue ;
                   if(isPrime(i))
                   {
                   int k = i ;    
                   for(int j = i * i ; j <= n ;)
                   {
                       values[j] = false ;
                        j = i * (k++);
                   }
                   }
             }
              
              int count = 0 ; 
              for(int i = 1 ; i < values.length; i++)
              {
                  if(values[i])
                      count++ ;
            
             }
              
              return count ; 
          }

}
