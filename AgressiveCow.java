Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows. 
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3 
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8, 
resulting in a minimum distance of 3.
Download Test Cases
//binary Search Problem

import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here

        Scanner sc = new Scanner (System.in) ;
      
        int t = sc.nextInt() ; 
       
      while(t > 0)
      {
        
        int n = sc.nextInt() ; 
        int c = sc.nextInt() ;
        
        int arr[] = new int [n] ;
        
        for(int i = 0 ; i < n ; i++)
           arr[i] = sc.nextInt() ; 
        
        Arrays.sort(arr) ;
    
     
     // int   mid = max / 2;
                 
    
    
     int min = 0 ;
     int max = arr[n - 1] - arr[0] ;
     int ans = 0;    
        while(min <= max )
        {
          
          int  mid = max + min / 2 ;
          if(check(arr, mid , c))
          {
            
             min = mid + 1 ; 
            if(mid > ans)
            {
              ans = mid ;
            }
          }
          else
          {
          
            max = mid - 1 ;
          
          }
          
       
          
        }
        System.out.println(ans) ;
        
       
        t-- ;
      }
    }  
      
      static boolean  check(int arr [] , int mid, int c)
      {
            
       int Pos = 0;
       int pos = 1 ;
        for(int i = 1 ; i < arr.length ; i ++ )
        {
           if(arr[i] - arr[Pos] >= mid )
           { 
             Pos = i ;
             pos = pos + 1;
           
           }
          if(pos == c)
            return true ;
        }
        
        return  false ;
      }
      
      
      
	

}
