/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.*;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
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
  
    public static void main(String args[] ) throws Exception {
       
    FastReader f = new FastReader() ;
     
    int T = f.nextInt() ;
    
    while(T > 0)
    {
        int Nums = f.nextInt() ;
         
        int AddArr[] = new int[Nums] ;
        int SubArr[] = new int[Nums] ;
        
        for(int i = 0 ; i < Nums ; i++)
        {
            int Num = f.nextInt() ;
            AddArr[i] = Num + i ;
            SubArr[i] = Num - i ;
        }
        System.out.println(findMaxSum(AddArr, SubArr)) ;
        
        
        T-- ;
    }
      
      
      
      
      
    }
    
    static int findMaxSum(int AddArr[] , int SubArr[])
    {
      int ans1 , ans2 ;
      
      Arrays.sort(AddArr) ;
      
      ans1 = AddArr[AddArr.length - 1] - AddArr[0] ;
      Arrays.sort(SubArr) ;
      
      ans2 = SubArr[SubArr.length - 1] - SubArr[0] ;
              
      return Math.max(ans1 , ans2) ;  
        
    }
  
    
}
