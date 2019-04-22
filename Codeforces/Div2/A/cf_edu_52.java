import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
        int n = sc.nextInt() ; 
        sc.nextLine() ; 
        String s = sc.nextLine() ;
        
        int l ,r;
        if(n == 2)
        {
            if(s.charAt(0) > s.charAt(1))
            {
                System.out.println("YES") ;
                System.out.println(1+" "+2) ;
                return ;
            } 
            else
            {
                System.out.println("NO") ;
                return ;
            }
        }
       
        for(int i = 0 , j = 1; i < n && j < n;)
        {
            if(s.charAt(i)  > s.charAt(j))
            {
                System.out.println("YES") ;
                System.out.println((i + 1)+" "+(j + 1)) ;
                return ;
            }
            else
            {
                i = j ;
                j++ ;
            }
        }
        System.out.println("NO");
        
    
    }
     
  
}
