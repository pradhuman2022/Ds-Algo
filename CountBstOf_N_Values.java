class Solution
{
static int m = 1_000_000_000 + 7;
  	public static int countTrees(int n) {
       if(n == 0 || n == 1)
           return 1 ;
       int x = 0 ;
       int dpCat[] = new int[n + 1] ;
       dpCat[0] = 1 ; 
       dpCat[1] = 1;
       for(int i = 2 ; i <= n ; i++)
       {
           for(int j = 0 ; j < i ;j++)
               dpCat[i] = ((dpCat[i] % m)+ ((((dpCat[j] % m)* (dpCat[i - j - 1] % m)) % m) % m))%m;  
       }
      return dpCat[n] ;
     
    }
    }
