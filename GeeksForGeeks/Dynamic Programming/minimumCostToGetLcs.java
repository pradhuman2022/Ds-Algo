import java.io.*;

class GFG {
    static String str1;
    static String str2;
	public static void main (String[] args) {
	    str1 = "abble";
	    str2 = "pie";
	    int k = 2;
	    System.out.println(minimumCost(str1.length() - 1, str2.length() - 1, k));
	}/*
	    i was blank ki kese k size ki length ko manage krege or 
	    kya steps honge agr i or j ko km krte hai toh.
	*/
	public static int minimumCost(int n, int m, int k) {
        if(k == 0)
            return 0;
	    if(n < 0 || m < 0)
	        return 1000000000;
	    int xorValue = (str1.charAt(n) - 'a') ^ (str2.charAt(m) - 'a');
	    int min = Math.min(minimumCost(n - 1, m - 1, k - 1) + xorValue, minimumCost(n - 1, m, k));
	    min = Math.min(min, minimumCost(n, m - 1, k));
	    return min;
	}
}
