import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in); 
	    int testCase = sc.nextInt();
	    
	    while(testCase-->0) {
	        int N = sc.nextInt(); 
	        int arr[] = new int[N];
	        for(int i = 0; i < N; i++)
	            arr[i] = sc.nextInt();
	        printMaxSequence(arr, N);
	    }
	 }
	 static void  printMaxSequence(int arr[], int n) {
	     Pair [] p = new Pair[n]; 
	     p[0] = new Pair(); 
	     p[0].lastIndex = -1; 
	     p[0].sum = arr[0];
	     int max = 0; 
	     int lastIndex = 0; 
	     for (int i = 1; i < n; i++) {
	         p[i] = new Pair();
	         p[i].sum = arr[i];
	         p[i].lastIndex = -1 ; 
	         for(int j = 0; j < i ; j++) {
	             if(arr[i] > arr[j] && p[j].sum + arr[i] > p[i].sum) {
                    p[i].lastIndex = j;
                    p[i].sum = p[j].sum + arr[i];
	             }
	         }
	         
	         if(max < p[i].sum) {
	             max = Math.max(max, p[i].sum);
	             lastIndex = i; 
	         }
	     }
	    String st = "";
	    int currentIndex = lastIndex ; 
	    while(-1 != currentIndex){
	        st = arr[currentIndex]+" "+st; 
	        currentIndex = p[currentIndex].lastIndex; 
	    }
	    System.out.println(st);
	 }
	 
	 static class Pair{
	     int sum; 
	     int lastIndex ; 
	 }
}
