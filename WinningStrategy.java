import java.util.*;

public class Main {

    public static void main(String ar[])
    {
         Scanner sc = new Scanner(System.in) ;
         
         int n = sc.nextInt() ;
         
         int [] ws = new int[n] ; 
         
         for(int i = 0 ; i < n ; i++)
             ws[i] = sc.nextInt() ; 
         
         Ws(ws) ;
    }
    
    static void Ws(int ws[])
    {
      
         int swaps = 0 ;
        for(int i = ws.length - 1 ; i >= 0 ; i--)
        {
            if(ws[i] != i + 1)
            {
            if(ws[i - 1] == i+1)
             {
               swaps++ ;
               int temp = ws[i - 1] ;
               ws[i - 1] = ws[i];
               ws[i] = temp ;
             }
             else if(ws[i - 2] == i + 1)
             {
                  swaps += 2 ;
              
               ws[i - 2] = ws[i  - 1] ;
               ws[i - 1 ] = ws[i] ; 
               ws[i] = i+1 ;
             }
             else {
                 System.out.println("NO") ;
                 return ;
             }
        }
        }
        System.out.println("YES");
        System.out.println(swaps);
    }
    
}
