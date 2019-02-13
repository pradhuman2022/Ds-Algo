Result
Distribute Candies
Send Feedback
Shaky has N (1<=N<=50000) candy boxes each of them contains a non-zero number of candies (between 1 and 1000000000). Shaky want to distibute these candies among his K (1<=K<=1000000000) IIIT-Delhi students. He want to distibute them in a way such that:
1. All students get equal number of candies.
2. All the candies which a student get must be from a single box only.
As he want to make all of them happy so he want to give as many candies as possible. Help Shaky in finding out what is the maximum number of candies which a student can get.
Input
First line contains 1<=T<=20 the number of test cases. Then T test cases follow. First line of each test case contains N and K. Next line contains N integers, ith of which is the number of candies in ith box.
Output
For each test case print the required answer in a seperate line.
Sample Input:
2
3 2 
3 1 4
4 1
3 2 3 9
Sample Output:
3
9


import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here

      Scanner sc= new Scanner(System.in) ; 
      
      long T = sc.nextLong() ;
      
      while(T > 0) 
      {
        int n = sc.nextInt() ; 
        long k = sc.nextLong() ;
        
        long Boxes[] = new long [n] ;
        for(int i = 0 ; i < n ; i ++)
          Boxes[i] = sc.nextLong() ; 
        Arrays.sort(Boxes) ;
        System.out.println(getLarge(Boxes, 0, Boxes.length - 1, k)) ;
        
        T-- ;
        
      }
      
      
	}
  
  static long getLarge(long []Boxes, long start , long end, long students)
  {
   // int mid = start + end / 2 ; 
    
   // int mid = Boxes[Boxes.length - 1] / 2; // intially max 
    start = 0;  
    end = Boxes[Boxes.length - 1] ;
    long ans = 0 ;
     while(start <= end)
     {
     long  mid = (start + end) / 2 ;
       
      // ans = mid ; 
       if(CheckPossible(Boxes, mid, students))
       {
        start = mid + 1 ; 
         if(mid > ans)
           ans = mid ;
       }
       else
       {
         end = mid - 1 ;
       }
     }
    return ans ; 
    
  }
  static boolean CheckPossible(long Boxes[], long mid , long students)
  {
     long maxCandies = 0 ;
     
      for(int i = 0 ; i < Boxes.length ; i++)
      {
         long val = Boxes[i] / mid ; 
       maxCandies = maxCandies + val ; 
        if(maxCandies >= students) 
          return true ;
       
        
      }
       
    return false ;
    
  }
    
    
    
    
    
    
    
    
    
    
    
}
