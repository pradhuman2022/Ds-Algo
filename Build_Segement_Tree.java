/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
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
}
