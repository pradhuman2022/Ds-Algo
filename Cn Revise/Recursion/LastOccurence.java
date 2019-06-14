public class Solution {

	public static int lastIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        return ff(input, x, input.length - 1) ;
	}
    static int ff(int input[], int x, int i)
    {
        if(i == -1)
            return -1 ;
        if(input[i] == x)
            return i ;
        int ans = ff(input, x, i - 1) ;
        return ans; 
    }
	
}
