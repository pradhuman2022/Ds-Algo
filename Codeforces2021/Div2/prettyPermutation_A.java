import java.util.*;

public class Main {
    
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0) {
            int n = sc.nextInt();
            
            if(n % 2 == 0)
                    System.out.println(generate(n));
            else 
                System.out.println("3 2 1" + generate(n));
        }
    }
    static String generate(int n) {
        String ans = "";
        
        int x = 1;
        
        if(n % 2 != 0)
            x = 4;
        
        while(x <= n) {
            ans = ans + " " + (x + 1);
            ans = ans  + " " + x;
            x = x + 2;
        }
        return ans;
    }
}
