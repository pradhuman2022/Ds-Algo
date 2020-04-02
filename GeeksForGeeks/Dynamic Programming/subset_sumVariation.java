/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		while(testCases-->0) {
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    int arr[] = new int[N];
		    for (int i = 0; i < N; i++)
		        arr[i] = sc.nextInt();
		    System.out.println(isSubsetPossible(arr, N, M)) ;
		}
	}
    static int isSubsetPossible(int arr[], int N, int M) {
        boolean dp[] = new boolean [M];
        for (int i = 0; i < N; i++) {
            if(dp[0])
                return 1; 
            for (int j = 0; j < M; j++) {
                if(dp[j]) 
                    dp[(j + arr[i]) % M] = true;
            }
            dp[arr[i] % M] = true;
        }
        return 0; 
    }
}
