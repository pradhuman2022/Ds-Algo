/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt() ;
		while(T-- > 0)
		{
		    int n = sc.nextInt() ;
		    int x = sc.nextInt() ;
		    int arr[] = new int[n];
		    for(int i = 0 ; i < n ; i++)
		    {
		        arr[i] = sc.nextInt() ;
		    }
		    int ans1 = firstOccur(arr,x);
		    int ans2 = lastOccur(arr,x) ;
		    if(ans1 == -1 || ans2 == -1)
		    System.out.println(ans1) ;
		    else
		    System.out.println(ans1+" "+ans2) ;
		}
		
	}
	static   int firstOccur(int A[], int x)
    {
        int low = 0 ; 
        int high = A.length - 1 ;
        while(low <= high)
        {
            int mid = (low + high) / 2 ;
            if(A[mid] == x && (mid == 0 || A[mid - 1] < x))
            {
                  return mid ;
            }else if(A[mid] > x||A[mid] == x && A[mid - 1] == x)
            {
                high = mid - 1 ;
            }else//(A[mid] < x)
            {
                low = mid + 1 ;
            }
        }
        return -1 ;
    }
    
    static   int lastOccur(int A[], int x)
    {
        int low = 0 ;
        int high = A.length - 1 ;
        while(low <= high)
        {
            int mid = (low + high) / 2 ;
            
            if(A[mid] == x && (mid == A.length - 1 ||A[mid + 1] != x))
            {
                  return mid ;
            }else if(A[mid] < x || A[mid] == x && A[mid + 1] == x)
            {
                low = mid + 1 ;
            }else//e(A[mid] < x)
            {
                high = mid - 1 ;
            }
        }
        return -1 ;
    }
}
