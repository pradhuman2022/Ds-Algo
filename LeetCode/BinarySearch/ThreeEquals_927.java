class Solution {
    public int[] threeEqualParts(int[] A) 
    {   
        int sum = 0 ;
        for(int x : A)
            sum +=x ;
        
        if(sum % 3 != 0)
            return new int[]{-1, -1} ;
        sum = sum / 3 ;
        if(sum == 0)
            return new int[]{0, A.length - 1} ;
        int i1 = -1 , j1 = -1 , i2 = -1, j2 = -1 ,i3 = -1 , j3 = -1 ;
        int k = 0; 
        for(int i = 0 ; i < A.length; i++)
        {
            if(A[i] == 1)
            {
                k++; 
                if(k == 1)
                    i1 = i;
                if(k == sum)
                    j1 = i ;
                if(k == sum + 1)
                    i2 = i ;
                if(k == 2 * sum)
                    j2 = i ;    
                if(k == 2 * sum + 1)
                    i3 = i ;
                if(k == 3 * sum)
                    j3 = i ;
            }
        }
        int part1[] = Arrays.copyOfRange(A, i1,  j1 + 1) ;
        int part2[] = Arrays.copyOfRange(A, i2,  j2 + 1) ;
        int part3[] = Arrays.copyOfRange(A, i3,  j3 + 1) ;
      if(!Arrays.equals(part1, part2))
          return new int[]{-1,-1} ;
      if(!Arrays.equals(part2, part3))
          return new int[]{-1,-1} ;
      
       int x = i2 - j1 - 1 ;
       int y = i3 - j2 - 1 ;
       int z = A.length - j3 - 1 ;
       
       if(x < z || y < z)
           return new int[]{-1, -1};
       else
           return new int[]{j1 + z, j2 + z + 1} ;
        
    }
}
