/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in) ;
		int T = sc.nextInt() ;
		while(T-- > 0)
		{
		    int n = sc.nextInt() ;
		    int a[] = new int[n] ;
		    int map[] = new int[2001] ;
		    for(int i = 0 ; i < n; i++)
		    {
		        a[i] = sc.nextInt();
		        map[a[i]]++ ;
		    }
		    int k = sc.nextInt() ;
		    //Arrays.sort(a) ;
		    int pairs = 0 ;
		    if(n == 1 || k == 0)
		     {
		         System.out.println(pairs) ;
		         continue ;
		     }
		    for(int i = 0 ; i < n ; i++)
		    {
		        if(map[a[i] ^ k] == 1)
		        {
		         pairs++ ;
		         map[a[i]] = 0 ;
		        }
		        // System.out.println(a[i] ^ k);
		    }
		    System.out.println(pairs) ;
		}
	}
}
