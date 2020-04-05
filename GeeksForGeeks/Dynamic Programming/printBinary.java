/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    static boolean dp[] ; 
    static int N ; 
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in);
	   N = sc.nextInt();
	   int k = sc.nextInt();
	   dp = new boolean[(int)Math.pow(2, N)];
	   for (int i = 0 ; i <= N; i++) {
	       list.add(new ArrayList<String>());
	   }
     String str = "";
     for(int i = 0; i < N; i++)
     	str = str + "0";
	   printCombination(str, 0);	
	   for(String binary : list.get(k))
	    System.out.print(binary+" ");
	}
	static void printCombination(String bitPattern, int setBits) {
	
	    if(setBits > N)
	        return ;
	    int val = Integer.parseInt(bitPattern,2);
	    if(dp[val])
	        return;
	    list.get(setBits).add(bitPattern);
	    for(int i = 0; i < N; i++)
	        if(bitPattern.charAt(i) - '0' == 0)
	            printCombination(bitPattern.substring(0, i) + "1"+bitPattern.substring(i + 1, N), setBits + 1);
	    dp[val] = true;
	    
	}
}
