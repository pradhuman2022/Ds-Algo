import java.util.* ;
public class SegmentTree {
    public static void main(String ar[])
    {
         Scanner sc = new Scanner(System.in) ; 
         int n = sc.nextInt() ;
         int arr[] = new int[n] ;
         for(int i = 0 ; i  < n ; i++)
             arr[i] = sc.nextInt() ;
         int tree[] = new int [2 * n] ;
         buildTree(arr, 1, 0 , n - 1, tree) ;
         for(int x : tree)
             System.out.println(x) ;
         System.out.println("-------------------------------") ;
         updateTree(1,tree, arr, 0 , n - 1, 3, 6) ;
                 for(int x : tree)
             System.out.println(x) ;
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
        tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1] ;
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
        if(in > mid) //feel like binary search 
        {
            updateTree(2 * treeNode + 1 , tree, arr,mid + 1, end , in , value) ;
        }
        else
        {
            updateTree(2 * treeNode , tree, arr, start , mid,in , value) ;
        }
        tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1] ;
    }
}
