import java.util.Scanner;

public class Main {

	 public static void main(String ar[])
    {
         Scanner sc = new Scanner(System.in) ; 
         int n = sc.nextInt() ;
         int q = sc.nextInt() ;
         int arr[] = new int[n] ;
         for(int i = 0 ; i  < n ; i++)
             arr[i] = sc.nextInt()  ;   
         int tree[] = new int [4 * n] ; //always take size of tree as 4 * n == 2 * pow(2, ceil(logn)) 
         buildTree(arr, 1, 0 , n - 1, tree) ;
       //   sc.nextLine() ;  
         while(q-- > 0)
         {
             String k = sc.next() ;
             int  l = sc.nextInt() ;
             int  r = sc.nextInt() ;
             
             if(k.equals("u"))
             {
                 updateTree(1,tree, arr, 0 , n - 1, l - 1, r) ;
             }else
             {
                 System.out.println(performQuery(tree, 0, n - 1,r - 1,l - 1,1)) ;
             }
             
             
         }
         
    }
    static void buildTree(int arr[], int treeNode, int start , int end, int tree[])
    {
        if(start == end)
        {
            tree[treeNode] =  arr[start] ; 
            return  ;
         }
        int mid = (start + end) / 2 ;
        buildTree(arr, 2 * treeNode, start , mid, tree) ;
        buildTree(arr, 2 * treeNode + 1 , mid + 1, end , tree) ;
        tree[treeNode] = Math.min(tree[2 * treeNode] , tree[2 * treeNode + 1]) ;
    }
    static void updateTree(int treeNode, int tree[] , int arr[], int start , int end , int in, int value)
    {
        if(start == end)
        {
            tree[treeNode] = value ; 
            arr[in] = value ;
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
        tree[treeNode] = Math.min(tree[2 * treeNode] , tree[2 * treeNode + 1]) ;
    }
    static int performQuery(int tree[],int start , int end , int right , int left , int treeNode) 
    {
        if(start > right || end < left)// completly outside 
            return Integer.MAX_VALUE ;
        
        if(start >= left && end <= right) // completely inside 
            return tree[treeNode] ;
        int mid = (start + end) / 2 ; // partially inside ,outside
        int ans1 = performQuery(tree, start , mid , right , left , 2 * treeNode) ;
        int ans2 = performQuery(tree, mid + 1, end , right, left , 2 * treeNode + 1) ;         
        return Math.min(ans1, ans2) ;
    }

}
