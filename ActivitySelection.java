import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner sc = new Scanner(System.in); 
      int n = sc.nextInt() ;
      int start[] = new int[n] ;
      int finish[] = new int[n] ;
      //hello world
      int i = 0 ;
      while(i < n)
      {
      start[i] = sc.nextInt() ;
      finish[i] = sc.nextInt() ;
      
      i++ ;
      }
      MergeSort(start, finish, 0 ,start.length - 1)  ;
      System.out.println(MaxActivities(start, finish)) ;
      
	}
  
    static void MergeSort(int start[], int finish[] , int si, int ei) 
  {
    if(si >= ei)
      return ;
    
    int mid = (si + ei) / 2 ;
    
    MergeSort(start , finish, si, mid) ;
    MergeSort(start, finish, mid + 1 , ei);
    Merge(start, finish, mid, si, ei);
  }
  
  static void Merge(int start[], int finish[], int mid ,int si, int ei)
  {
    
    int l = mid - si + 1 ;
    int r = ei - mid ;
    
    int Ls[] = new int[l] ;
    int Rs[] = new int[r] ;
    
    int Lf[] = new int[l] ;
    int Rf[] = new int[r] ;
    
    for(int i = 0 ; i < l; i++)
    {
      Lf[i] = finish[si + i] ;
      Ls[i] = start[si + i] ;
      
    }
       
    for(int i = 0; i < r ; i++)
    {
      Rf[i] = finish[mid + i + 1] ;
      Rs[i] = start[mid + i + 1];
         
    }
    
    int i = 0, j = 0, k = si ;
    
    while(i < Lf.length && j < Rf.length)
    {
      if(Lf[i] > Rf[j])
      {
        finish[k] = Rf[j] ;
        start[k] = Rs[j] ;
        j++;
      }
      else
      {
        finish[k] = Lf[i] ;
        start[k] = Ls[i] ;
        i++;
      }
      k++ ;
   }
   while(i < Lf.length)
   {
     finish[k] = Lf[i] ;
     start[k] = Ls[i] ;
     i++ ;
     k++ ;
     
   }
   
    while(j < Rf.length)
    {
      finish[k] = Rf[j] ;
      start[k] = Rs[j] ;
      j++;
      k++ ;
    }
    
  }
  
   

   static long MaxActivities(int start[] , int finish[])
  {
    
    long maxActivities[] = new long[start.length];
    maxActivities[0] = 1 ;
   int  finalEndTime = finish[0] ;
    int j = 1 ;
    for(int i = 1 ; i < finish.length; i++)
    {  
      if(start[i] >= finalEndTime)
      {
        maxActivities[i]  = maxActivities[i - 1] + 1 ;
        finalEndTime = finish[i] ;
        
      }
      else
          maxActivities[i] = maxActivities[i - 1] ;
      j = i;
    }

    
    return maxActivities[j] ;
  }

  
}
