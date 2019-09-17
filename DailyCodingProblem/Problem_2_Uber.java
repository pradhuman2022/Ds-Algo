
public class SpecialProducts {
	
	public static void main(String ar[])
	{
		int arr[] = new int[]{1,2,3,4,5};
		for(int x : findProductsOfElements(arr))
		{
			System.out.print(x+" ");
		}
	}

	static int [] findProductsOfElements(int arr[])
	{
		int n = arr.length ;
		int postProduct[]  = new int[n] ;
		int preProduct[] = new int[n] ; 
		preProduct[0] = arr[0] ;
		postProduct[n - 1] = arr[n - 1] ;
		
		for(int i = 1 ; i < n ; i++)
		{
			preProduct[i] = arr[i] * preProduct[i - 1];
		}
		
		for(int i = n - 2 ; i >= 0 ; i--)
		{
		    postProduct[i] = postProduct[i + 1] * arr[i] ;	
		}
		int ans[] = new int[n] ;
		for(int i = 0 ; i < n ; i++)
		{
			if(i == 0)
				 ans[i] = postProduct[i + 1] ;
			else if(i == n - 1)
				 ans[i] = preProduct[i - 1] ;
			else
				ans[i] = preProduct[i - 1] * postProduct[i + 1] ;
		}
		
		return ans ;
	}
}
