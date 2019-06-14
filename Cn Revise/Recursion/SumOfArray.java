public class Solution {
              // static int n=0; 
             
	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        return sum(input, 0 , 0);
        
	}
    static int sum(int input[], int i, int sum)
    {
        if(i == input.length - 1)
        {
            return sum + input[i];
        }
        int ans = sum(input, i + 1, sum + input[i]) ;//+ input[i] ;
        return ans;
    }
}
