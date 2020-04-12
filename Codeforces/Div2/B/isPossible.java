    import java.util.*;
    import java.io.BufferedReader; 
    import java.io.IOException; 
    import java.io.InputStreamReader; 
    import java.util.Scanner; 
    import java.util.StringTokenizer; 
    public class MyCode {
       
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
       public static void main(String ar[]) {
        
         FastReader sc = new FastReader();
         int testCases = sc.nextInt();
         while(testCases-->0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int b[] = new int[n];
            for(int i = 0; i < n; i++)
                b[i] = sc.nextInt();
            System.out.println(isPossible(a, b, n));
            }
       }
        static String isPossible(int a[], int b[], int n){
            boolean isMinusOne = false;
            boolean isPositiveOne = false;
            boolean isZero = false;
            HashSet<Integer> set = new HashSet<Integer>();
            
            for(int i = 0 ; i < n; i++){
               if(a[i] == b[i]){
                   set.add(a[i]);
                   continue;
               }
               int diff = b[i] - a[i];
               if(diff > 0) {
                   if(!set.contains(1))
                    return "NO" ; 
               }else {
                   if(!set.contains(-1))
                    return "NO" ; 
               }
               set.add(a[i]);
            }
            return "YES" ;
         
        } 
         
    }
