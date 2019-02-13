There are ‘n’ number of balls in a container. Mr. Sharma and Singh want to took balls out from the container. At each step, Mr. Sharma took ‘k’ balls out of the box and Mr. Singh took one-tenth of the remaining balls. Suppose there are 29 balls at the moment and k=4. Then, Mr. Sharma will take 4 balls and Mr. Singh will take 2 balls (29-4 = 25; 25/10 = 2). If there are less than ‘k’ balls remaining at some moment, then Mr. Sharma will take all the balls which will get the container empty. The process will last till the container becomes empty. Your task is to choose minimal ‘k’ for Mr. Sharma such that Mr. Sharma will take at least half of the balls from the container.
Input Format:
Only line of input contains a single integer ‘n’.
Output Format:
Print a single integer denoting the minimal value of ‘k’.
Constraints:
1 <= n <= 10^18
Time Limit: 1 second
Sample Input:
68
Sample Output:
3
Explanation:
68-3 = 65; 65/10 = 6; 65-6 = 59
59-3 = 56; 56/10 = 5; 56-5 = 51
51-3 = 48; 48/10 = 4; 48-4 = 44
44-3 = 41; 41/10 = 4; 41-4 = 37
…..
…..
…..
6-3 = 3; 3/10 = 0; 3-0 = 3
3-3 = 0; 0/10 = 0; 0-0 = 0
Download Test Cases


1
import java.util.*;
2
​
3
    public class Main {
4
    public static void main(String[] args) {
5
        Scanner in = new Scanner(System.in);
6
        long balls = in.nextLong() ;
7
      System.out.println(CountMin(balls)) ;
8
    }
9
      static long CountMin(long n)
10
    {
11
        long start = 1 ; 
12
        long end = n ;
13
        long ans = n ;
14
        while(start <= end)
15
        {
16
            long mid = (start + end) / 2 ;
17
            if(check(n, mid))
18
            {
19
           
20
             end = mid - 1 ;
21
                if(mid < ans)
22
                    ans = mid ;
23
            }
24
            else
25
            {
26
                start = mid + 1 ;
27
            }
28
        }
29
        return ans ;
30
    }
31
    
32
   static boolean check(long n , long k)
33
    {
34
        long sum = 0 ;
35
        long curr = n ;
36
        long val = 0 ;
37
        while(curr >= 0) 
38
        {
39
            // System.out.println(" v");
40
            sum = sum + Math.min(k,curr) ;
41
            val = curr ;
42
            curr = (val - k) / 10 ;
43
            curr = (val - k ) - curr ;
44
            
45
        }
46
        if(2*sum >= n)
47
            return true ;
48
              
49
      return false ;  
50
    }
51
}
