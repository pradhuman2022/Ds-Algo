/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
	    System.out.println(printDistinctCount("gfg"));
	}
	
	static int printDistinctCount(String str) {
	    int lastTime[] = new int[26];
	    Arrays.fill(lastTime, -1);
	    int count[] = new int[str.length() + 1] ;
	    count[0] = 1;
      
      //we are adding 2 because , we have two choice whther we can add ith element to (i - 1) subsequences or leave it as same.
      //we are substracting because [.......][i - 1].....[i.....] suppose i and i - 1 are same so we need to substract all 
      //sequences obtained from 0 to i - 2 because we already have created subsequences for i - 2th element.
	    for (int i = 1; i <= str.length(); i++) {
	        count[i] =  2 * count[i - 1]; 
	        
	        if(lastTime[str.charAt(i - 1) - 97] != -1) {
	            count[i] = count[i] - count[lastTime[str.charAt(i - 1) - 97]];
	        }
	        lastTime[str.charAt(i - 1) - 97] = (i - 1);
	    }
	   return count[str.length()]; 
	}
}
