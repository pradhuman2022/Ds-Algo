import java.util.* ; 

public class Contest_Div21 {
    
    public static void main(String ar[])
    {
       Scanner sc = new Scanner(System.in) ;
       int T = sc.nextInt() ; 
       while(T > 0)
       {
           T-- ;
           int n = sc.nextInt() ;
           sc.nextLine() ;
           String s = sc.nextLine() ;
           if(s.charAt(0) == '>' || s.charAt(s.length() - 1) == '<' || s.length() == 1)
           {
               System.out.println(0) ;
               continue ;    
           }
            int i = 0 ;//<<><><><>>
            while(i < n)
            {
                if(s.charAt(i) == '>')
                    break ;
                i++ ;//>><>
            }
            int j = n - 1 ;
            while(j >= 0)
            {
                if(s.charAt(j) == '<')
                    break ;
                j-- ;
            }
            System.out.println(Math.min(i, (n  - 1) - j)) ;
           
       }
    }
}
