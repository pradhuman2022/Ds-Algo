import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner input = new Scanner(System.in);
	 int cases = input.nextInt();
	 
	 while(cases-->0){
	     int n = input.nextInt();
	     int arr[] = new int[n];
	     for(int i = 0 ; i < n ; i++)
	        arr[i] = input.nextInt();
	     System.out.println(trap(arr));     
	 }
	 
	 }
    public static int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        
        for(int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], height[i]);
        
        for(int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i]);
        
        int water = 0;
        for(int i =0; i < n ;i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
       return water;  
        
    }

}
