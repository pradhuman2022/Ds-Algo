import java.util.* ;
import java.io.* ;
class Solution
{
      static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
     
     public static void main(String ar[])
    {
        int c = 1 ;
        FastReader sc = new FastReader();     
        int T = sc.nextInt() ;
        while(T-- > 0)
        {
            int N =sc.nextInt() ;
            int Q = sc.nextInt() ;
      
            String str = sc.nextLine() ;
            int f[][] = new int[26][N + 1];
          //  System.out.println("exception ouccured after 67") ;
            for(int i = 0 ; i < 26 ; i++)
            {
                for(int j = 0 ; j < N ; j++)
                {
                    f[i][j + 1] = f[i][j] + (str.charAt(j) == i + 'A' ? 1 : 0) ;
                }
            }
            
             long ans = 0 ; 
            while(Q-- > 0)
            {
                int l = sc.nextInt() ;
                int r = sc.nextInt() ;
                if(yesOrNot(l, r, f))
                ans++ ;
            }
         System.out.println("Case #" + c +": "+ans) ;//*/
         c++ ;
        }
    }
    static boolean yesOrNot(int l , int r , int f[][])
    {
        long odd = 0 ;
        long even = 0 ;
        for(int i = 0 ; i < 26 ; i++)
        {
            int v = f[i][r] - f[i][l - 1] ;
            if(v % 2 == 1)
            odd++ ;
            if(odd > 1)
                return false ;
            
        }
        return  true ;
    } 

}
