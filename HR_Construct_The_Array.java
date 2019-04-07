import java.util.* ;
public class Construct_the_Array {
   
    static long Ways(int n , int k , int x)
    {
        
        long OneCount = 1 ;
        long NonOneCount = 0;
        int mod = 1000000000+7 ; 
        for(int i = 1 ; i < n ; i++)
        {
            long prevOneCount  = OneCount; 
            OneCount = ((k - 1) * NonOneCount) % mod  ;
            NonOneCount = ((((k - 2) * NonOneCount) % mod) + prevOneCount) % mod ; 
        }
        if(x == 1)
            return OneCount ;
        else
            return NonOneCount ;
    }
}
