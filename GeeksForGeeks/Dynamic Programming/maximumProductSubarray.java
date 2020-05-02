import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main (String[] args)
	 {
	 //code
	    FastReader sc = new FastReader();
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i = 0; i < n; i ++){
	             arr[i] = sc.nextInt();
	       }
	       System.out.println(maxProductSubarray(arr, n)) ;
	    }
	 
	 }/*
	    i was blank for this solution, how we can have minvalue updated and
	    maxvalue as well.
	    basically hm kadens ki tarah hi krre hai bs minvalue maintain
	    krni pdegi kyuki 'negative -ve' +ve krdege.
	 */
	 static long maxProductSubarray(int arr[], int n) {
	     long max_ending_here = 1;
	     long min_ending_here = 1; 
	     long max_product_so_far = Integer.MIN_VALUE; 
	     for(int i = 0; i < n; i++) {
	         if(arr[i] < 0){
	             long prevMax = max_ending_here;
	             max_ending_here = min_ending_here * arr[i];
	             min_ending_here = prevMax * arr[i]; 
	         }else if(arr[i] > 0){
	             max_ending_here = max_ending_here * arr[i];
	             min_ending_here = Math.min(1, min_ending_here * arr[i]); 
	         }else {
	             min_ending_here = 1; //{all -v values}{a[i]}{all -value} then -ve bhi return krna pdega.
	             max_ending_here = 0; /*because answer can bev zero also, becasuse if max_so_Far having -ve values
                                    then we need to update it with zero.*/
	         }
	         
	         max_product_so_far = Math.max(max_product_so_far, max_ending_here); 
	         if(max_ending_here <= 0)
	            max_ending_here = 1; 
	     }
	     return max_product_so_far;
	 }
}
