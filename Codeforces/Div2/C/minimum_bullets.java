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
            long health[] = new long[n];
            long damage[] = new long[n];
            for(int i = 0; i < n; i++) {
               health[i] = sc.nextLong();
               damage[i] = sc.nextLong();
            }
            System.out.println(minNumberOfBullets(health, damage, n));
         }
       }
         static long minNumberOfBullets(long health[], long damage[], int n){
            long minimumRequireBullets = 0 ;
            long firstTargetedMonster = Long.MAX_VALUE; 
            for(int monster = 0; monster < n; monster++) {
               int nextMonster = (monster + 1) % n;
               long healthOrDamage = Math.min(health[nextMonster], damage[monster]);
               minimumRequireBullets += health[nextMonster] - healthOrDamage ; 
               firstTargetedMonster = Math.min(firstTargetedMonster, healthOrDamage) ;
            }
            return minimumRequireBullets + firstTargetedMonster ; 
         }
    }
