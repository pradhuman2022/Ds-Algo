public class solution {
static int inversion = 0 ;
  public static void mergeSort(int[] input)
  {
    mergeSort(input, 0, input.length-1);
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
    
    int k = start;
    while(i < l && j <r)
    {
       
    if(L[i] > R[j])
    {
      input[k] = R[j] ;
      j++;
      //k++;
      
    }
    else 
    {
      input[k] = L[i] ;
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
}
