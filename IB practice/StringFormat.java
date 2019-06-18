public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final String A, final String B) {
           StringBuffer s = new StringBuffer(A) ;
           s = s.append(B) ;
           int i = 0 ;
           int len = s.length() ;
           int j = A.length() ;
           int ans = 0 ;
           HashSet<String>hs = new HashSet<String>() ;
           for(int i1 = 0 ; i1 < A.length() ; i1++)
           hs.add(Character.toString(A.charAt(i1))); 
           
           HashSet<String>hs1 = new HashSet<String>() ;
           for(int i1 = 0 ; i1 < B.length() ; i1++)
           hs1.add(Character.toString(B.charAt(i1))); 
           
           if(hs1.size() != hs.size())
            return 0 ;
           
           while(i < len && j < len)
           {
             if(s.charAt(i) == s.charAt(j))
             {
                 ans = 1 ;
                 j++ ;
             }
            else
              {
               if(s.charAt(i + 1) == s.charAt(j)) 
               {
                   i++ ;
                   ans = 1;
                   continue ;
               }
               ans = 0 ;
               break ;
              }
           }
           if(A.charAt(A.length() -1) != B.charAt(B.length() - 1))
            ans = 0 ;
           
           return ans ;
           
           /*
        for(int i = 0, j = 0  ; i < A.length()  ;)
        {
            if(j == B.length() && i < A.length() || (j <= B.length() - 2 && i == A.length() - 1 && A.charAt(i) != B.charAt(j + 1)))
            {
                ans = 0 ; 
                break ;
            }
                
            
            if(A.charAt(i) == B.charAt(j))
             {
                 ans = 1 ;
                 j++ ;
             }
            else
              {
               if(i + 1 < A.length() &&   A.charAt(i + 1) == B.charAt(j)) 
               {
                   i++ ;
                   ans = 1;
                   continue ;
               }
               ans = 0 ;
               break ;
                 
              }
        }
        return ans; */
    }
}
