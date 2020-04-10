import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner input = new Scanner(System.in);
	    int cases = input.nextInt();
	    
	    while(cases-->0){
	        int n = input.nextInt();
	        input.nextLine();
	        String s[] = input.nextLine().split(" ");
	        HashSet<String> set = new HashSet<String>();
	        for (int i = 0; i < s.length; i++) {
	           set.add(s[i]);
	        }
	        String word = input.nextLine();
	        System.out.println(isWordBreakPossible(set, word));
	    }
	 
	 }
	 static int isWordBreakPossible(HashSet<String> set, String word) {
	    int len = word.length(); 
	    boolean dp[] = new boolean[len + 1]; 
	    if(len == 0)
	        return 0 ; 
	    for(int i = 1; i <= len; i++) {
	        if(!dp[i] && set.contains(word.substring(0, i)))
	            dp[i] = true;
	        if(dp[i]) {
	            if(i == len)
	                return 1; 
	            for(int j = i + 1; j <= len; j++) {
	                 String str1 ; 
	                // try {
	                      str1 = word.substring(i, j) ;  
	                // }catch(Exception e) {
	                     //return 0; 
	                 //}
	                 //System.out.println(str1);
	                 if(!dp[j] && set.contains(str1))
	                    dp[j] = true;
	                if(j == len && dp[j])
	                    return 1; 
	            }
	        }
	    }
	    return 0; 
	 }
}
