    import java.util.*;
         
        public class MyCode{
           
           public static void main(String ar[]){
              
              Scanner sc = new Scanner(System.in) ;
              int n = sc.nextInt() ; 
              
              int arr[] = new int[n] ; 
              for(int i = 0 ; i < n ; i++)
               arr[i] = sc.nextInt() ; 
             getMaxOdd(arr, n) ; 
           }
           
           static void getMaxOdd(int arr[], int n){
              int max = Integer.MIN_VALUE ;
              int min = Integer.MAX_VALUE ; 
              int sum = 0 ; 
              
              for(int i = 0 ; i < n ; i++)
               {
                  if(arr[i] > 0)
                   {
                      sum += arr[i] ; 
                      if(arr[i] % 2 != 0)
                        min = Math.min(min, arr[i]) ; 
                   }
                   if(arr[i] % 2 != 0 && arr[i] < 0)
                      max = Math.max(max, arr[i]) ; 
               }
               
               if(sum % 2 != 0)
                System.out.println(sum) ; 
               else
                System.out.println(Math.max(sum + max, sum - min));
           }
        }
