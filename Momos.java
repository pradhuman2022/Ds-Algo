Momos Market
Send Feedback
Shreya loves to eat momos. Her mother gives her money to buy vegetables but she manages to save some money out of it daily. After buying vegetables, she goes to "Momos Market", where there are ‘n’ number of shops of momos. Each of the shop of momos has a rate per momo. She visits the market and starts buying momos (one from each shop) starting from the first shop. She will visit the market for ‘q’ days. You have to tell that how many momos she can buy at each day if she starts buying from the first shop daily. She cannot use the remaining money of one day on some other day. But she will save them for other expenses in future, so, you also need to tell the sum of money left with her at the end of each day.
Input Format:
First line will have an integer ‘n’ denoting the number of shops in market.
Next line will have ‘n’ numbers denoting the price of one momo of each shop.
Next line will have an integer ‘q’ denoting the number of days she will visit the market.
Next ‘q’ lines will have one integer ‘X’ denoting the money she saved after buying vegetables.
Constraints:
1 <= n <= 10^5
1 <= q <= 10^5
1 <= X <= 10^9
Output:
There will be ‘q’ lines of output each having two space separated integers denoting number of momos she can buy and amount of money she saved each day.
Sample Input:
4
2 1 6 3
1
11
Sample Output:
3 2
Explanation:
Shreya visits the "Momos Market" for only one day. She has 11 INR to spend. She can buy 3 momos, each from the first 3 shops. She would 9 INR (2 + 1 + 6) for the same and hence, she will save 2 INR.
Download Test Cases

import java.io.*;
import java.util.*;
public class Main {
     
   static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

	
	public static void main(String[] args)throws IOException {
		// Write your code here

    FastReader br = new FastReader(); 
                               
      int  n = br.nextInt() ;
      int  price []= new int[n] ;
      for(int i = 0 ; i < n ; i++)
        price[i] = br.nextInt();
     
      long sum[] = new long[n] ;
      sum[0] = price[0] ;
      for(int i = 1; i < n ; i++)
        sum[i] = sum[i - 1] + price[i] ;
      
      long q = br.nextLong() ;
      while(q > 0)
      {
         long paisa = br.nextLong() ;
         getLong(sum, paisa);
         q--;
      }
	}
  
  static void getLong(long []sum, long paisa )
  {
       int start = 0 ; 
       int end = sum.length  ;
      while(start <= end)
      {
        int mid = ( start + end) / 2 ;
         
        if(mid == 0)
        {
          if(paisa >= sum[0]) 
          {System.out.println("1" + " " + (paisa - sum[0])) ; 
           }
          else
          {
            System.out.println("0"+" "+paisa) ;
          }
          break;
        }
        if(paisa <= sum[mid] && paisa > sum[mid - 1])
        {
          if(paisa == sum[mid])
          {
            System.out.println((mid + 1)+" "+0);
           
          }
         else{
           int position = mid  ;
          System.out.println(position+" "+(paisa - sum[mid - 1])) ; 
         }
           break ;
        }
       if(paisa > sum[mid])
       {
         start = mid + 1;
        
       }
        else
        {
          end = mid -1 ;
        }
        
        
      }
   
  }
