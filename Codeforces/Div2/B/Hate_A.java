import java.util.* ;
public class Hate_A {
    public static void main(String ar[])
    {
        Scanner sc = new Scanner (System.in) ;
        String t = sc.nextLine() ;
        StringBuilder s1 = new StringBuilder() ;
        for(int i = 0 ; i < t.length() ; i++)
            if(t.charAt(i) != 'a') 
                s1.append(t.charAt(i)) ;
        String s = s1.substring(0, s1.length() / 2) ;
        String k = s1.substring(s1.length()/ 2 , s1.length());
        if(!s.equals(k))
        {
            System.out.println(":(");
            return ;
        }
        for(int i = t.length() - 1 ; i >= t.length() - k.length() ;i--)
        {
         if(t.charAt(i) == 'a')
         {
             System.out.println(":(");
             return ;
         }
        }
        System.out.println(t.substring(0,t.length() - k.length()));
        
    }
