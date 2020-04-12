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
            int x = sc.nextInt();
            int wealthOfPerson[] = new int[n];
            for(int i = 0; i < n; i++) {
               wealthOfPerson[i] = sc.nextInt();
            }
            System.out.println(getNumberOfWealthyPersons(wealthOfPerson, n, x));
         }
       }
         static long getNumberOfWealthyPersons(int wealthOfPerson[], int n, int x){
             long countWealthyPersons = 0;
             Arrays.sort(wealthOfPerson);
             long sumOfWealth = 0; 
             for(int wealth = n - 1; wealth >= 0 && sumOfWealth + wealthOfPerson[wealth] >= x * (countWealthyPersons + 1); wealth--) {
                 sumOfWealth += wealthOfPerson[wealth] ; 
                 countWealthyPersons++;
             }
             return countWealthyPersons;
         }
    }
