import java.util.* ;
public class Solution {
    public int getSum(int A, int B, int C, int[] D, int[] E, int[] F) {
       
       int a[] = new int[A + 1]; 
       int c[] = new int[C + 1];
        Arrays.sort(E);
        Arrays.sort(D);
        Arrays.sort(F) ;
       for(int i = 1 ; i < A + 1; i++)
       {
           a[i] = D[i - 1] + a[i - 1] ;
       }
      for(int j = 1 ; j < C + 1; j++)
      {
        c[j] = c[j - 1] + F[j - 1];
      }
      int mod = (int)Math.pow(10, 9) + 7 ;
      int ans[] = new int[B] ;
      for(int i = 0 ; i < B ; i++)
      {
         int x = E[i] ;
          int low1 = 0 ;
          int end1 = D.length - 1 ;
          while(low1 < end1)
          {
              int mid = (low1 + end1) / 2 ;
              if(D[mid] > x)
               end1 = mid - 1 ;
              else
                low1 = mid + 1 ;
          }                      
          while(low1 > 0 && D[low1] > x)
          low1-- ;
        
          int low2 = 0 ;
          int end2 = F.length - 1 ;
          while(low2 < end2)
          {
              int mid = (low2 + end2) / 2 ;
              if(F[mid] > x) 
               end2 = mid - 1 ;
              else
               low2 = mid + 1 ;
          }
          while(low2 > 0 && F[low2] > x) 
          low2-- ;
          
          if(x < D[low1] || x < F[low2])
          {
              ans[i] = 0 ;
          }else
          
          {
              int k1 = (x * (low1 + 1)) + a[low1 + 1] ;
              int k2 = (x * (low2 + 1))+ c[low2 + 1] ;
              ans[i] = (k1 * k2) % mod ;
          }
          
          
      }
      
      int sum = 0 ;
      for(int i = 0; i < B ; i++)
      sum = (sum + ans[i]) % mod ;
      return sum ;
      
      /* ArrayList<Integer> al = new ArrayList<Integer>() ;//b + c
       ArrayList<Integer> al1 = new ArrayList<Integer>() ;// a + c
       
       for(int b = 0 ; b < E.length ; b++)
       {
           for(int c = 0 ; c < F.length ; c++)
           {
               if(F[c] <= E[b])
                 al.add(F[c] + E[b]) ;
           }
       }
        for(int b = 0 ; b < E.length ; b++)
       {
           for(int a = 0 ; a < D.length ; a++)
           {
               if(D[a] <= E[b])
                 al1.add(D[a] + E[b]) ;
           }
       }
       int mod = (int)Math.pow(10, 9) + 7 ;
       int sum = 0 ;
       for(int i = 0 ; i < al.size(); i++)
       {
           for(int j = 0; j < al1.size(); j++)
           {
               sum = (sum % mod + (al.get(i) * al1.get(j)) % mod) % mod ;
           }
       }
        
        return sum ;*/
    }
}
