Murder
Send Feedback
Once detective Saikat was solving a murder case. While going to the crime scene he took the stairs and saw that a number is written on every stair. He found it suspicious and decides to remember all the numbers that he has seen till now. While remembering the numbers he found that he can find some pattern in those numbers. So he decides that for each number on the stairs he will note down the sum of all the numbers previously seen on the stairs which are smaller than the present number. Calculate the sum of all the numbers written on his notes diary.
Answer may not fit in integer . You have to take long.
Input
First line gives T, number of test cases.

2T lines follow.

First line gives you the number of stairs N

Next line gives you N numbers written on the stairs.
Output
For each test case output one line giving the final sum for each test case.
Constraints
T<=10

1<=N<=10^5

All numbers will be between 0 and 10^6.
Sample Input:
1
5
1 5 3 6 4
Sample Output:
15
Explanation:
For the first number, the contribution to the sum is 0.
For the second number, the contribution to the sum is 1.
For the third number, the contribution to the sum is 1.
For the fourth number, the contribution to the sum is 9 (1+5+3).
For the fifth number, the contribution to the sum is 4 (1+3).
Hence the sum is 15 (0+1+1+9+4).
Download Test Cases

import java.util.Scanner;

public class Main {

  static long sum = 0 ;
    
    
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
    
     for(int i1 = 0; i1 < l; i1++)
      L[i1] = input[start + i1];
    for(int j1 = 0; j1 < r; j1++)
      R[j1] = input[mid +1 +  j1];
    
    
  
    int i = 0 ;
    int j = 0;
    
    int k = start;
    while(i < l && j <r)
    {
       
    if(L[i] >= R[j])
    {
      input[k] = R[j] ;
      j++;
      //k++;
      
    }
    else 
    {
      input[k] = L[i] ;
      
      sum = sum + ( (R.length - j ) * (L[i])) ; 
      //System.out.println(sum +"exe"+    L[i])  ;
     i++;
      // inversions ++ ;
      //k++;
    }
       k++;
    }    
    while( i < l)
    {
      input[k] = L[i];
      i++;
      k++;
      
    }
    while( j < r)
    {
      input[k] = R[j] ;
      j++ ;
      k++;
      
    }
  //  int ks=start;
   }
public static void main(String[] args) {
		// Write your code here
         
       java.util.Scanner sc = new java.util.Scanner(System.in) ;
      int  T = sc.nextInt() ;
      while(T > 0)
      {
        int n = sc.nextInt() ;
        int arr[]= new int [n] ;
        for(int i = 0 ; i < n ; i ++ )
        {
          arr[i] = sc.nextInt() ;
        }
        
        mergeSort(arr, 0 , arr.length - 1) ;
        arr = null ;
        System.out.println(sum) ;
     
        sum = 0 ;
        T--;
      }
      
	}
	


}
