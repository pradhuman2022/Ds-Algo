/*
find the minimum length of all substrings contains k constants :
if "ritikisagoodboy" is string and k is 4 then 
minimum length  is 9 .
*/

public class CandidateCode {
    static boolean checkValue[] ;
    public static void main(String ar[])
    {
        String s = "ritikisa";
        checkValue = new boolean[s.length()];
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) != 'a'&& s.charAt(i) != 'e'&& s.charAt(i) != 'i'&& s.charAt(i) != 'o'&& s.charAt(i) != 'u')
            {
                checkValue[i] = true ;
            }
        }
        System.out.println(findMinimum(s,4)) ;
    }
    static int findMinimum(String s, int k)
    {
        int ans = Integer.MAX_VALUE ;
        int startlen = 0;
        int endlen = s.length();
        int count = 0;
        while(startlen <= endlen)
        {
            int mid = (startlen + endlen) / 2 ;
            if(isPossible(mid, s, k, count))
            {
                if(ans >= mid)
                  ans = mid ;
                endlen = mid - 1 ;
            }
            else
                startlen = mid + 1 ;
            count++;
        }
        if(ans == Integer.MAX_VALUE)
        return -1 ;
        else
            return ans ;
    }
    static boolean isPossible(int mid ,String s, int k, int count)
    {
       int NoOfStrings = s.length() - mid + 1 ;
       int dp []= new int[NoOfStrings] ;
       for(int i = 0 ; i < mid ; i++)
       {
           if(checkValue[i] == true) {
           
               dp[0]++ ;
           }
       }
       for(int i = 1 ; i < NoOfStrings; i++)
       {     
             if(dp[i - 1]>= k)
             {
              if(checkValue[i - 1] == false)
              {
                  if(checkValue[i + mid - 1] == true)
                  {
                      dp[i] = dp[i - 1] + 1;
                  }
                  else
                  {
                      dp[i] = dp[i - 1] ;
                  }
              }
              else
              {     
                  if(checkValue[i + mid - 1] == true)
                      dp[i] = dp[i - 1] ;
                  else
                      dp[i] = dp[i - 1] - 1 ;
              }
                 
             }
             else{
                break ; 
             }
       }
       for(int i = 0 ; i < dp.length ; i++)
       {
         //  System.out.println(dp[i] +" "+ count) ;
           if(dp[i] < k)
               return false ;
       }
      return true;
    }
}
