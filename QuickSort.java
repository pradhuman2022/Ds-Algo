
public class Solution {
	
	public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
         quickSort(input, 0, input.length-1);
		
	}
	
   static void quickSort(int []input, int start, int end)
   {
     
     if(start >= end)
       return ;
     
     int c = partition(input, start, end) ;
     quickSort(input, start, c-1) ;
     quickSort(input, c+1, end);
     
   }
  
  static int partition(int input[], int start, int end)
{
    int count = 0;
    
   int pivot = input[start] ;
   
   for(int find = start+1 ; find <= end ; find++)
   {
       if(pivot > input[find])
           count++;
   }
   input[start] = input[start + count];
   input[start + count] = pivot ;
   
   int i = start , j = end ;
   while(i < start + count && j > start + count)
   {
       
       if(input [ i ] >= pivot )
       {
           while (j > start + count && input[j] >= pivot)
             j--;
           
           int temp  = input[ j ] ;
           input [ j ] = input [ i ] ; 
           input [ i ] = temp ; 
           i++ ;      
        }
       else if( input [j ] < pivot)
       {
           while(i < start + count && input[ i] < pivot)
           {
               i++;
           }
          int temp  = input[ j ] ;
           input [ j ] = input [ i ] ; 
           input [ i ] = temp ; 
           j--;           
       }
       else
       {
           i++;
           j--;
       }
   }
   
   
    return start + count ;
}
  }
