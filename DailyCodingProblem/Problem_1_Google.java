import java.util.Arrays;

public class Try {
    
	public static void main(String ar[])
	{
		
		int arr[] = new int[]{10, 15, 3, 7} ;
		int k = 17 ;
		System.out.println(isPossible(arr, k)) ;
	}
	
	static boolean isPossible(int arr[], int k)
	{
		Arrays.sort(arr);
		for(int i = 0 ; i < arr.length; i++)
		{
			if(find(arr, i, k - arr[i])) 
				 return true ;
		}
		return false ;
	}
	
	static boolean find(int arr[], int i , int FValue)
	{
		int start, end ; 
		
		if(arr[i] > FValue)
		{
			start = 0; 
			end =  i - 1;
		}else
		{
			start = i + 1 ;
			end = arr.length - 1 ;
		}
		
		while(start <= end)
		{
			int mid = (start + end)/ 2 ;
			//System.out.println(arr[mid]) ;
			if(arr[mid] == FValue) 
				 return true ;
			
			if(arr[mid] > FValue)
				 end = mid - 1; 
			else
				start = mid  + 1;
		}
		return false ;
	}
	
}
