import java.util.*;
class MaxSum
{
 public static void main(String ar[])
 {
   Scanner sc = new Scanner(System.in) ;
   int n = sc.nextInt(); 
   int arr[] = new int[n] ;
   System.out.println(solve(arr, n)); 
 }
 
 public static int solve(int arr[], int n)
 {
    int currentSum = arr[0] ; 
    int maxSum = arr[0] ; 
    
    for(int i = 1 ; i < n ; i++) 
    {
      currentSum = Math.max(currentSum + arr[i], arr[i])  ; 
      maxSum = Math.max(currentSum, maxSum) ;
      
      if(currentSum < 0)
        currentSum = 0 ;  
      }  
   return maxSum ;
  }
}
