import java.io.*;
import java.util.*;


public class TestClass {
    static int parent[];
    static String XA; 
    static String YB;
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
    public static void main(String[] args) throws IOException {
         FastReader br = new FastReader();
         String A = br.nextLine();
         String B = br.nextLine();
         String C = br.nextLine();

         String out_ = Solution(A, C, B);
         System.out.println(out_);
    }

    static String Solution(String A, String C, String B){
        // Write your code here
        XA = A; 
        YB = B;
        int length = A.length();
        parent = new int[27];
        for(int i = 1; i < 27; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < length; i++){
            union(i, i);
        }
        
        String smallestString = "";
        for(int i = 0; i < C.length(); i++) {
            smallestString += (char)(find(C.charAt(i) - 97 + 1) - 1 + 97);
        }
        return smallestString;
    }

    static void union(int xA, int yB) {
        int xset = find(XA.charAt(xA) - 97 + 1);
        int yset = find(YB.charAt(yB) - 97 + 1);
        //case1 if xset and yset are equal then do nothing.
        //case2 if xset and yset are different, then choose parent, which is lexographically smallest.
        if(xset > yset) {
            parent[xset] = yset; //to maintain lexographically order.
        }else {
            parent[yset] = xset;
        }
    }

    static int find(int x) {
        if(parent[x] != x)
             parent[x] = find(parent[x]);
        return parent[x]; 
    }
}
