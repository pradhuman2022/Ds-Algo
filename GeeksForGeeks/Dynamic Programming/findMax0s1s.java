import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static String S;
    static int preProcess[]; 
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    sc.nextLine();
	    while(testCases-->0) {
	        S = sc.nextLine();
	        preProcess = new int [S.length()];
	        for(int i = 0 ; i < S.length(); i++) {
	            if(S.charAt(i) == '0')
	                preProcess[i] =  1; 
	            else
                    preProcess[i] = -1; 	           
	        }
	       
	        System.out.println(maxDifference()); 
	    }
	 
	 }
	 /*
	    mai is qustn m 0 ko -1 and 1 ko as 1 rhne derha tha jiska mtlb
	    hota ki difference between 1s and 0s, jbki hmko max diff nikalana 
	    0s to 1s.
	    so 0 ko 1 convert kr dia and 1 ko -1.
	 */
	 static int maxDifference() {
	    
	    int currentSum = 0;
	    int maxSum = Integer.MIN_VALUE; 
	    for (int i = 0; i < preProcess.length; i++) {
	        currentSum += preProcess[i] ; 
	        maxSum = Math.max(maxSum, currentSum);
	        if(currentSum < 0)
	            currentSum = 0; 
	    }
	    return maxSum; 
	 }
}
