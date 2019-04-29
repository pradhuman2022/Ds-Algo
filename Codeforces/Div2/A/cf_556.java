import java.util.*;
public class LazyPropogation {
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;
        int r = sc.nextInt() ;
        
        int min = Integer.MAX_VALUE ;
        //int max1 = Integer.MAX_VALUE ;
        
        while(n-- >0)
        {
            int k = sc.nextInt() ;
            min = Math.min(min, k) ;
            //max1 = Math.max(max1, k) ;
        }
       int max = Integer.MIN_VALUE ;
        while(m -- >0)
        {
            int k = sc.nextInt() ;
            max = Math.max(max, k) ;
            //min2 = Math.min(min2, k) ;
        }
        int profit = Integer.MIN_VALUE ;
        for(int i = 0 ; i <= Math.max(min, max) ; i++)
        {
            if(r - (min * i) >= 0)
            {
               int profit1 = r - (min * i) ;
                profit1 += (max * i) ;
                profit = Math.max(profit , profit1) ;
            }
        }
       
        
        System.out.println(profit) ;
    }
   
}
