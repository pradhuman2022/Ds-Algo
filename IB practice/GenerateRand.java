import java.util.* ;
public class Rand7 {
   static Random r = new Random();
    public static void main(String arg[])
    {
        System.out.println(rand7());
    }
    
    static int rand7()
    {
        int x = r.nextInt(6);
        int k = (5 * x) + x - 5;
        if(k < 22)
           return k % 7 + 1 ;
        else 
            return rand7();
    }       
            
    
}
