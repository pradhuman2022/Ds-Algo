import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() ; 
        int x = in.nextInt() ;
        int y = in.nextInt() ;
        
        in.nextLine() ; 
        String a = in.nextLine() ;
        long z = 0 ; 
       for(int i = 0 ; i < a.length() - 1; i++)
       {
           if(i == 0 && a.charAt(i) == '0')
               z++ ; 
           else if(a.charAt(i) == '1'  && a.charAt(i + 1) == '0')
               z++ ;
               
       }
    
        z = ((z - 1) * Math.min(x, y) )+ y ;
        
        System.out.println(z) ;
        
        
	}
}
