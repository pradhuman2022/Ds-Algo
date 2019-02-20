import java.io.*;
public class test {
 public static void main(String ar[])throws IOException
 {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
     
     int n = Integer.parseInt(br.readLine());
     int k = Integer.parseInt(br.readLine());
     
     int lastCity = n - k ;
     if(lastCity < 0)
     {
         System.out.println(n) ;
     }
     else
     {
         System.out.println(((lastCity * (lastCity + 1) / 2) + k - 1)) ;
     }
 }
}
