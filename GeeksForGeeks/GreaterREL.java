import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++)
		    {
		        arr[i] = sc.nextInt();
	
		    }
		    int mr [] = new int[n];
		    mr[n - 1] = arr[n - 1];
		    
		    for(int j = n - 2; j >= 0; j--)
		    	
		        mr[j] = Math.max(arr[j + 1],mr[j+1]);
  
		    
		    //if(mr[n - 2] != mr[n - 1])
		      mr[n - 1] =-1;
		      
		     for(int x:mr) 
		     System.out.print(x+" ");
		     System.out.println();

		}
	}
}
