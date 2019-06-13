/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pradhuman
 */
import java.util.*;
public class InversionCountVariation {
        static int invCount = 0 ;
        
     public static void main(String ar[])
     {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int A[] = new int[n] ;
         for(int i = 0 ; i < n ; i++)
         {
             A[i] = sc.nextInt() ;
         }
         new InversionCountVariation().solve(A) ;
         for(int x: A)
             System.out.print(x+" ");
         System.out.println() ;
         System.out.println(invCount) ;
     }
        
    public int solve(int[] A) {
     mergeSort(0, A.length - 1, A);
     return invCount ;
    }
    void mergeSort(int start, int end, int A[])
    {
        if(start >= end)
         return ; 
        int mid = (start + end) / 2 ;
         mergeSort(start , mid , A); 
         mergeSort(mid + 1, end, A) ;
         merge(start, end , mid, A) ;
    }
    void merge(int start , int end , int mid , int A[])
    {
        int L[] = new int[mid - start + 1] ;
        int R[] = new int[end - mid] ;
        
        for(int i = 0 ; i < L.length; i++)
         L[i] = A[i + start] ;
         
        for(int i = 0 ; i < R.length;i++)
          R[i] = A[mid + 1 + i] ;
          
        int i = 0 ; 
        int j = 0 ; 
        int k = start ;
        
        int l = 0 ; 
        int e = L.length - 1 ;
        for(int t = 0 ; t < R.length ; t++)
        {
            while(l <= e && L[l] <= R[t] * 2)
            {
                l++ ;
            }
              invCount += (e - l + 1);
        }
        
        while(i < L.length && j < R.length)
        {
            if(L[i] > R[j])
            { 
                A[k++] = R[j++] ;
            }else
            {
                A[k++] = L[i++] ;
            }
        }
        
        while(i < L.length)
        {
            A[k++] = L[i++] ;
        }
        while(j < R.length)
        {
            A[k++] = R[j++];
        }
    }


}
