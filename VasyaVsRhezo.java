import java.util.* ;
import java.io.* ;
public class VasyaVsRhezo {
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
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long A[] = new long[n];
        long B[] = new long[n];
        for(int i = 0 ; i < n ; i++)
            A[i] = sc.nextInt() ;
        for(int i = 0 ; i < n ; i++)
            B[i] = sc.nextInt() ;
        int T = sc.nextInt();
        Node[] tree = new Node[4 * n] ;
        for(int i = 0 ; i < 4 * n ; i++)
            tree[i] = new Node() ;
        buildTree(tree, A , B, 1, 0 , n - 1) ;
        while(T-- >0)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            Node ans = performQuery(tree, 1, 0, n - 1, l -1 , r - 1);
            System.out.println(ans.index + 1);
        }
    }
    static void buildTree(Node tree[], long A[],long B[], int treeNode , int start , int end)
    {
       if(start == end)
       {
           tree[treeNode].max = A[start] ;
           tree[treeNode].min = B[start] ;
           tree[treeNode].index = start ;
           return ;
       }
       int mid = (start + end) / 2 ;
       buildTree(tree, A, B , 2 * treeNode, start , mid) ;
       buildTree(tree, A, B, 2 * treeNode + 1, mid + 1, end) ;
       Node left = tree[2 * treeNode] ;
       Node right = tree[2 * treeNode + 1] ;
       if(left.max > right.max)
       {
           tree[treeNode].max = left.max ;
           tree[treeNode].min = left.min ;
           tree[treeNode].index = left.index ;
       }
       else if(left.max < right.max)
       {
           tree[treeNode].max = right.max ; 
           tree[treeNode].min = right.min ;
           tree[treeNode].index = right.index ;
       }
       else
       {
           if(left.min < right.min)
           {
               tree[treeNode].max = left.max ;
               tree[treeNode].min = left.min ;
               tree[treeNode].index = left.index ;
               
           }
           else if(left.min > right.min)
           {
               tree[treeNode].max = right.max ; 
               tree[treeNode].min = right.min ;
               tree[treeNode].index = right.index ;
           }
           else 
           {
               if(left.index < right.index)
               {
                   tree[treeNode].max = left.max ;
                   tree[treeNode].min = left.min ;
                   tree[treeNode].index = left.index ;
               }
               else
               {
                   tree[treeNode].max = right.max ;
                   tree[treeNode].min = right.min ;
                   tree[treeNode].index = right.index ;
               }
           }
       }
        
    }
    
    static Node performQuery(Node tree[],int treeNode, int start , int end, int l , int r)
    {
        if(start > r || end < l)
            return new Node() ;
        if(start >= l && end <= r)
            return tree[treeNode] ;
        
        int mid = (start + end) / 2 ;
        
        Node left = performQuery(tree, 2 * treeNode, start , mid , l, r) ;
        Node right = performQuery(tree, 2 * treeNode + 1, mid + 1, end, l , r) ;
        Node ans = new Node() ;
        if(left.max > right.max)
        {
            ans = left ;
        }
        else if(left.max < right.max)
        {
            ans = right ;
        }
        else
        {
            if(left.min < right.min)
                ans = left ;
            else if(left.min > right.min)
                ans = right ;
            else
            {
                if(left.index < right.index)
                    ans = left; 
                else
                    ans = right ;
            }
        }
        return ans ;
    }
    static class Node
    {
        long max = Long.MIN_VALUE ; 
        long min = Long.MAX_VALUE;
        int index = Integer.MAX_VALUE ; 
    }
    
}
