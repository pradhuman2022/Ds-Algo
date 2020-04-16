import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    while(testCases-->0){
	        int days = sc.nextInt();
	        int highEffortsOn[] = new int[days];
	        int lowEffortsOn[] = new int[days]; 
	        
	        for (int i = 0; i < days; i++)
	            highEffortsOn[i] = sc.nextInt();
	        for (int i = 0; i < days; i++)
	            lowEffortsOn[i] = sc.nextInt();
	        System.out.println(maximumEffortRequiredInDays(highEffortsOn, lowEffortsOn, days));
	    }
	 }
	 static int maximumEffortRequiredInDays(int highEfforts[], int lowEfforts[], int totalDays) {
	 int maximumEffortTill[] = new int[totalDays + 1]; 
	 maximumEffortTill[0] = 0;
	 maximumEffortTill[1] = highEfforts[0]; 
	 for (int i = 2; i <= totalDays; i++) 
	    maximumEffortTill[i] = Math.max(maximumEffortTill[i - 2] + highEfforts[i - 1], maximumEffortTill[i - 1] + lowEfforts[i - 1]) ; 
	     
	 return maximumEffortTill[totalDays];    
	 }
}
