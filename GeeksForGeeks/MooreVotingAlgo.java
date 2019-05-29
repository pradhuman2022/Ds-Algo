/*package whatever //do not write package name here */

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;
class GFG {
 
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
  
	public static void main (String[] args) {
		//code
		FastReader sc = new FastReader() ;
		int T = sc.nextInt() ;
		int arr[] ;
		while(T-- > 0)
		{
		  int n = sc.nextInt() ;
		  arr = new int[n] ; 
		  for(int i = 0 ; i < n ;i++)
		  arr[i] = sc.nextInt() ;
          System.out.println(ansMajorElement(getMajorElement(arr, n), arr)) ;
		}
	}
	static int getMajorElement(int arr[], int n)
	{
	    int count = 1;
	    int maxIndex = 0 ;
	    for(int i = 1 ; i < n ; i++)
	    {
	        if(arr[i] == arr[maxIndex])
	         {
	             count++ ;
	         }
	        else
	          count-- ;
	        
	       if(count == 0)
	       {
	           maxIndex = i ;
	           count = 1 ;
	       }
	    }
	    return maxIndex ;
	}
	static int ansMajorElement(int index, int arr[])
	{
	    int count = 0 ; 
	    int ansCount = arr.length / 2 ; 
	    for(int i = 0 ; i < arr.length ; i++)
	    {
	        if(arr[i] == arr[index])
	        count++ ;
	    }
	    if(count > ansCount)
	     return arr[index] ;
	    else 
	    return -1 ;
	}
}
