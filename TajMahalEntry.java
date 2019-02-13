Taj Mahal Entry
Send Feedback
Taj Mahal is one of the seven wonders of the world. Aahad loves to travel places and wants to visit Taj Mahal. He visited Agra to view Taj Mahal. There is a ticketing system at Taj Mahal. There are total ‘n’ windows which provide the tickets to get entry into Taj Mahal. There are ‘Ai’ people already present at each window to get the tickets. Each window gives ticket to one person in one minute. Initially, Aahad stands in front of the first window. After each minute, if he didn’t get the ticket, he moves on to the next window to get the ticket. If he is at window 1, he will move to 2. If at 2nd, he will move to 3rd. If he is at last window, he will move to 1st again and so on. Find the window number at which he will get the ticket.
Input Format:
First line contains a single integer ‘n’ denoting the no. of windows.
Next line contains ‘n’ space separated integers denoting the no. of people already standing in front of the ith window. (1 <= i <= n)
Output Format:
Print a single integer denoting the window number that Aahad will get ticket from.
Constraints:
1 <= n <= 10^5
1 <= Ai <= 10^9
Sample Input:
4
2 3 2 0
Sample Output:
3
Explanation:
Aahad at Window 1: [2, 3, 2, 0]
Aahad at Window 2: [1, 2, 1, 0]
Aahad at Window 3: [0, 1, 0, 0]
So, when Aahad is at window 3, he got zero people before him. Hence, he will get the ticket at window 3

import java.util.*;

public class Main {
  static int position = 1 ;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
  static boolean terminate = false ;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() ;
        int window [] = new int[n] ;
        int win[] = new int[n];
       for(int i = 0 ; i < n ; i++)
       {
          window[i] = in.nextInt() ;
       //   win[i] = window[i] ;
       }
     // Arrays.sort(win);
      System.out.print(TaJEntry(window, win[win.length - 1])) ;
	}
 
   public static int TaJEntry(int people[] , int maxVal)
   {
     
     int p1[] = new int[people.length] ;
     for(int i = 0 ; i < people.length ; i ++)
     {
       p1[i] = people[i] ;
     }
     boolean wontget = false ;
     int cycle = 0 ; 
     while(!wontget)
     {
      
       if(cycle != 0) 
       {
         for(int i = 0 ; i < people.length ; i++)
         {
           int cal = p1[i] - (p1.length - i) ;
           if(cal <= 0)
             return i+1 ;
           p1[i] = cal ;
           
         }
         
       }
       else
       {
         for(int i = 0 ; i < people.length; i++)
         {
           int cal = p1[i] - i ;
            // int cal = p1[i] - (p1.length - ) ;
           if(cal <= 0)
             return i+1 ;
           p1[i] = cal ;
         }
       }
       
     }
     
     return 0 ;
     }
     
   }
  
   
  
  
  
  
