/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
		//code
		public static void main(String arg[]){
		    Scanner sc = new Scanner(System.in) ;
		    
		    int T = sc.nextInt() ; 
		    long ugly_Numbers [] = new long[10001] ;
		     CalcUglyNumbers(ugly_Numbers) ;
		
		    while(T-->0){
		    int n = sc.nextInt() ; 
		    System.out.println(ugly_Numbers[n - 1]) ; 
		    }
		}
		static void CalcUglyNumbers(long ugly[]){
		    ugly[0] = 1 ;
		    int i2 = 0 ;
		    int i3 = 0 ;
		    int i5 = 0 ;

		   
		    long currMultipleOf2 = 2 ; 
		    long currMultipleOf3 = 3 ; 
		    long currMultipleOf5 = 5 ;
        
          for(int i = 1 ; i < ugly.length ; i++){
              
               long currUglyNum = Math.min(currMultipleOf2, Math.min(currMultipleOf3, currMultipleOf5));
               ugly[i] = currUglyNum ;
               if(currUglyNum == currMultipleOf2)
                 {
                     i2++ ; 
                     currMultipleOf2 = ugly[i2] * 2 ; 
                     //currMultipleOf2 is for checking , did you multiplied with i2 if yes then increment i2 and get next Value
                     //currMultipleOf2 is ugly[i2] * 2 
                     
                 }
               if(currUglyNum == currMultipleOf3)
                 {
                     i3++ ; 
                     currMultipleOf3 = ugly[i3] * 3 ; 
                 }
               if(currUglyNum == currMultipleOf5)
                 {
                     i5++ ; 
                     currMultipleOf5 = ugly[i5] * 5 ; 
                 }
          }		    
		}
}
