/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static int a , b, c; 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		System.out.println(maxDiff(sc.nextLine())) ;
	}
	
	static int maxDiff(String str){
	  //convert all 0 to 1 and 1 to -1 
	  //then use kadems algorithm
	  int n = str.length();
	
	  int maxSum = 0 ;
	  int currentSum = 0 ; 
	 
	  for (int i = 0; i < n; i++)
	  {
	        if(str.charAt(i) == '0')
	        currentSum++ ;
	        else 
	        currentSum--;
	        
	        if(currentSum < 0)
	         currentSum = 0;
	        
	        maxSum = Math.max(maxSum, currentSum);
	  }
	   
	  return maxSum ; 
	}
}
