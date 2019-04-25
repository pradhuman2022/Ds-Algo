
import java.util.Scanner;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
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

         int arr[] = new int[n] ;
         for(int i = 0 ; i  < n ; i++)
             arr[i] = sc.nextInt()  ;
         int q = sc.nextInt() ;
         node tree[] = new node [4 * n] ; //always take size of tree as 4 * n == 2 * pow(2, ceil(logn)) 
         buildTree(arr, 1, 0 , n - 1, tree) ;
       //   sc.nextLine() ;  
         while(q-- > 0)
         {
             String k = sc.next() ;
             int  l = sc.nextInt() ;
             int  r = sc.nextInt() ;

             if(k.equals("U"))
             {
                 updateTree(1,tree, arr, 0 , n - 1, l - 1, r) ;
             }else
             {
                 node ans = performQuery(tree, 0, n - 1,r - 1,l - 1,1) ;
                 System.out.println(ans.max+ans.smax) ;
             }


         }

    }
    static void buildTree(int arr[], int treeNode, int start , int end, node tree[])
    {
        if(start == end)
        {
            tree[treeNode] = new node() ;
            tree[treeNode].max =  arr[start] ; 
            tree[treeNode].smax = Integer.MIN_VALUE  ;
            return  ;
         }
        int mid = (start + end) / 2 ;
        buildTree(arr, 2 * treeNode, start , mid, tree) ;
        buildTree(arr, 2 * treeNode + 1 , mid + 1, end , tree) ;
        node left = tree[2 * treeNode] ;
        node right = tree[2 * treeNode + 1] ;
       
        tree[treeNode] = new node() ;
        tree[treeNode].max = Math.max(left.max, right.max) ;
        tree[treeNode].smax = Math.min(Math.max(left.smax, right.max), Math.max(left.max, right.smax));
        
    }
    static void updateTree(int treeNode, node tree[] , int arr[], int start , int end , int in, int value)
    {
        if(start == end)
        {
            tree[treeNode].max = value ; 
            arr[in] = value ;
            tree[treeNode].smax = Integer.MIN_VALUE ;
            return ;
        }
        
        
        int mid = (start + end) / 2 ;
        if(in > mid)
        {
            updateTree(2 * treeNode + 1 , tree, arr,mid + 1, end , in , value) ;
        }
        else
        {
            updateTree(2 * treeNode , tree, arr, start , mid,in , value) ;
        }
        
        node left = tree[2 * treeNode] ;
        node right = tree[2 * treeNode + 1] ;
        tree[treeNode].max = Math.max(left.max, right.max) ;
        tree[treeNode].smax = Math.min(Math.max(left.smax, right.max), Math.max(left.max, right.smax));
}
    static node performQuery(node tree[],int start , int end , int right , int left , int treeNode) 
    {
        if(start > right || end < left)// completly outside 
            return new node() ;

        if(start >= left && end <= right) // completely inside 
            return tree[treeNode] ;
        int mid = (start + end) / 2 ; // partially inside ,outside
        node ans1 = performQuery(tree, start , mid , right , left , 2 * treeNode) ;
        node ans2 = performQuery(tree, mid + 1, end , right, left , 2 * treeNode + 1) ;         
        node ans = new node() ;
        
        ans.max = Math.max(ans1.max, ans2.max) ;
        ans.smax = Math.min(Math.max(ans1.max, ans2.smax), Math.max(ans1.smax, ans2.max)) ;
        return ans ;
    }
    static class node
    {
        int max= Integer.MIN_VALUE ;
        int smax = Integer.MIN_VALUE;
    }

}
