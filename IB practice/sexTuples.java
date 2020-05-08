import java.util.*;

public class Solution {
    public int solve(int[] A) {
        return countSexTuplese(A, A.length);   
    }
    int countSexTuplese(int arr[], int n) {
    HashMap<Integer, Integer> distinctPairs1 = new HashMap<>();
    HashMap<Integer, Integer> distinctPairs = new HashMap<>();
    for(int f = 0; f < n; f++) {
    	for(int e = 0; e < n; e++) {
      	    for(int d = 0; d < n; d++) {
      	        if(arr[d] != 0){
        	    int expressionValue = (arr[f] + arr[e]) * arr[d];
                distinctPairs.put(expressionValue, distinctPairs.getOrDefault(expressionValue, 0) + 1); 
      	        }
        	}
      	 }
   	  }
    for(int a = 0; a < n; a++) {
    	for(int b = 0; b < n; b++) {
      	    for(int c = 0; c < n; c++) {
        	    int expressionValue = (arr[a] * arr[b] + arr[c]);
                distinctPairs1.put(expressionValue, distinctPairs1.getOrDefault(expressionValue, 0) + 1);
        }
      }
    }
    int count = 0;
    int mod = (int)Math.pow(10, 9) + 7;
    for(Map.Entry<Integer, Integer> m : distinctPairs.entrySet()) {
        int count1 = m.getValue();
        int count2 = distinctPairs1.getOrDefault(m.getKey(), 0);
        count = (count + (count1 * count2) % mod) % mod; 
    }
    return count;
}
        
}
