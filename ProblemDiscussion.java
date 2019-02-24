import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      
      Scanner sc = new Scanner(System.in) ;
      int n = sc.nextInt();
      long k = sc.nextLong();
      long v[] = new long[n];
      for(int i = 0; i < n; i++)
      {
        v[i] = sc.nextLong();
      }
      System.out.println(findMinDiff(v, n, k));
	}

      static long findMinDiff(long v[], int n , long k)
      {
           java.util.Arrays.sort(v) ;
        
           long min = v[0] + k ;
           long max = v[n - 1] - k;
          
        if(n == 1)
        {
          return v[0] - k ;
        }
           if(max < min)
           {
             long temp = max ;
             max = min ;
             min = temp ;
           }
        
        for(int i = 1 ; i < n - 1 ; i++)
        {
          long sub = v[i] - k ;
          long add = v[i] + k ;
          
          if(min <= sub || add <= max)
          {
           continue ;
          }
          else
          {
            
            if(max - sub <= add - min)
            {
              min = sub ;

            }
            else
            {
              max = add ;
             // v[i] = add ;
            }
            
          }
          
          
        }
      return max - min ;        
      }
  }
