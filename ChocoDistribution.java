import java.util.*; 
public class CandidateCode1 {
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in) ;
        int count = 0 ;
        int M = sc.nextInt() ;
        int N = sc.nextInt() ;
        int P = sc.nextInt() ;
        int Q = sc.nextInt() ;
        for(int l = M ; l <= N; l++)
        {
            for(int b = P ; b <= Q ; b++)
            {
                int l1 = l ; 
                int b1 = b ;
                while(l1 != 0 && b1 != 0)
                {
                   if(l1 == b1)
                   {
                       l1 = 0 ; 
                       b1 = 0 ;
                   }
                   if(l1 > b1)
                   {
                       l1 = l1 - b1 ;
                       
                   }else
                   {
                       b1 = b1 - l1 ;
                   }
                    count++ ;  
                }
            } 
        }
        System.out.println(count) ;
    }
}
