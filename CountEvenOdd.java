import java.util.Scanner;

public class CountEvenOdd {
                     
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int arr[] = new int[n] ;
        Node tree[] = new Node[4*n] ;
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt() ;
        }
        for(int i = 0 ; i < 4 * n ; i++)
            tree[i] = new Node() ;
        buildTree(tree, arr, 0, n - 1, 1) ;
       /* for(Node x : tree)
            System.out.println(x.even+" "+x.odd) ;
       */ int T = sc.nextInt() ;
        
        while(T-- > 0)
        {
            int q = sc.nextInt() ;
            int x = sc.nextInt() ;
            int y = sc.nextInt() ;
            if(q == 0)
            {
                updateTree(tree, arr, 0 , n - 1, 1, y , x -1) ;
            }
            else if(q == 1)
            {
                Node ans = performQuery(tree,1, x - 1 , y - 1, 0 , n - 1) ;
                System.out.println(ans.even);
            }
            else if(q == 2)
            {
                Node ans = performQuery(tree, 1, x - 1 , y - 1, 0, n - 1) ;
                System.out.println(ans.odd) ;
            }
        }
    }
    
    
    static void buildTree(Node tree[], int arr[], int start , int end, int treeNode)
    {
       if(start == end)
       {
           tree[treeNode] = new Node() ;
           if((arr[start] & 1) == 1)
           {
               tree[treeNode].odd = 1 ;
               tree[treeNode].even = 0;
           }
           else
           {
               tree[treeNode].even = 1 ; 
               tree[treeNode].odd = 0 ;
           }
           return ;
       }
       int mid = (start + end) / 2;
       buildTree(tree, arr, start, mid , 2 * treeNode) ;
       buildTree(tree, arr, mid + 1, end , 2 * treeNode + 1) ;
       tree[treeNode] = new Node() ;
       tree[treeNode].even = tree[2 * treeNode].even + tree[2 * treeNode + 1].even ;
       tree[treeNode].odd = tree[2 * treeNode].odd + tree[2 * treeNode + 1].odd ;
        
    }
    
    
    static void updateTree(Node tree[], int arr[], int start ,int end ,int treeNode, int value , int index)
    {
        if(start == end)
        {
            int prev = arr[index] ;
            arr[index]= value ;
            if((value & 1) == 1)
            {
             tree[treeNode].odd = 1  ;
             tree[treeNode].even = 0;
            }
            else
            {
                tree[treeNode].even = 1 ; 
                tree[treeNode].odd = 0;
            }
            return ;
        }
        int mid = (start + end) / 2 ;
        if(index > mid)
        {
            updateTree(tree, arr, mid + 1 ,end , 2 * treeNode + 1, value , index) ;
        }
        else
        {
            updateTree(tree, arr, start , mid , 2 * treeNode, value, index) ;
        }
        tree[treeNode].even = tree[2 * treeNode].even + tree[2 * treeNode + 1].even ;
        tree[treeNode].odd =  tree[2 * treeNode].odd +  tree[2 * treeNode + 1].odd ;
    }
    
    
    static Node performQuery(Node tree[],int treeNode,int left, int right , int start , int end) 
    {
        // complety outside
        if(start > right || end < left)
            return new Node() ;
        
        if(start >= left && end <= right)
            return tree[treeNode] ;
        
        int mid = (start + end) / 2 ;
        Node l  = performQuery(tree, 2 * treeNode, left, right, start , mid) ;
        Node r  = performQuery(tree, 2 * treeNode + 1 , left, right, mid + 1, end) ;
        Node ans = new Node();
        ans.even = l.even + r.even ;
        ans.odd  = l.odd + r.odd ;
        return ans ;
    }
    
    static class Node
    {
        int even ;
        int odd ;
    }
}
