SOLUTION

Problem
Result
Inversion Count
Send Feedback
Let A[0 ... n-1] be an array of n distinct positive integers. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A (where i and j are indexes of A). Given an integer array A, your task is to find the number of inversions in A.
Input format :
Line 1 : n, array size
Line 2 : Array elements (separated by space).
Output format :
Count of inversions
Constraints :
1 <= n <= 10^5
1 <= A[i] <= 10^9
Sample Input 1 :
3
3 2 1
Sample Output 1 :
3
Sample Input 2 :
5
2 5 1 3 4
Sample Output 1 :
4

public class solution {
	static long inversions = 0;
	long solve(int[] A,int n){
		
   		//Write your code here.
      mergeSort(A, 0, n - 1) ;
	  return inversions ;
	}
  
    
   	public static void mergeSort(int[] input, int start, int end){
      
		// Write your code here
	      if(start >= end)
            return ;
          
        int  mid = (start + end)/2;
       
      mergeSort(input, start, mid);
      mergeSort(input, mid+1, end);
      merge(input, start, end, mid);
	}
  
  static void merge(int input[], int start, int end, int mid)
  {
   // int mid = (start + end) / 2;
   
    int L[] = new int[mid-start+1];
    int R[] = new int[end-mid];   
    
    int l = mid-start+1;
    int r = end - mid;// end-mid;
 //   int k = 0;
    
    int a[]=new int[end-start+1];
    
    for(int i1 = 0; i1 < l; i1++)
      L[i1] = input[start + i1];
    for(int j1 = 0; j1 < r; j1++)
      R[j1] = input[mid +1 +  j1];
    
    int i = 0 ;
    int j = 0;
    int count = 0;
    int k = start;
      int count1 =  0 ;
    while(i < l && j <r)
    {
       
    if(L[i] > R[j])
    {
      input[k] = R[j] ;
      j++;
      //k++;
      count += L.length - i ;
       }
    else 
    {
      input[k] = L[i] ;
      i++;
      count1 ++;
     // inversions ++ ;
      //k++;
    }
       k++;
    }    
  
    
  //  System.out.println(count); //  System.out.println(count);
   
    inversions = inversions +  count;
   
  
      
      while( i < l)
    {
      input[k] = L[i];
      
      i++;
      k++;
     // count1 ++ ;
      
    }
    while( j < r)
    {
      input[k] = R[j] ;
      j++ ;
      k++;
      
    }
    //  int ks=start;
   }

	
}
