    import java.io.BufferedReader; 
    import java.io.IOException; 
    import java.io.InputStreamReader; 
    import java.util.Scanner; 
    import java.util.StringTokenizer; 
      
    public class Main 
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
      
                            public static void main(String ar[]){
                                      
                             FastReader sc = new FastReader();
                             int n = sc.nextInt();
                             
                             int max = (int)Math.pow(10, 6) + 10 ;
                             int count[] = new int[max];
                             
                             for(int i = 0 ; i < n ; i++){
                                count[sc.nextInt()]++ ; 
                             }                    
                             
                             int dp[] = new int[max];
                             int ans = Integer.MIN_VALUE ; 
                             for(int i = max - 1 ; i > 0 ; i--){
                                      
                                dp[i] = count[i] ; 
                     
                                for(int j = i + i ; j < max ; j += i)
                                  dp[i] = Math.max(dp[i], dp[j] + count[i]) ;
                                 
                                ans = Math.max(ans, dp[i]);    
                             }
                             System.out.println(ans) ;   
                           }          
    }
