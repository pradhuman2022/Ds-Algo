/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static int arr[];
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    arr = new int[]{9, 1, 2, 3, 9};
	    int k = 3;
	    System.out.println(maximumAverageSum(k, 0));
	}
	static int maximumAverageSum(int k, int position) {
	    
	    if(position == arr.length || k <= 0)
	        return 0;
	    int sum = 0 ;
	    int ans = Integer.MAX_VALUE;
	    for(int i = position; i < arr.length; i++) {
	        sum += arr[i];
	        ans = Math.min(ans, (sum / (i - position + 1)) + maximumAverageSum(k - 1, position + 1));
	    }
	    return ans;
	}
}
