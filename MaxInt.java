import java.util.*;
import java.math.* ;
class myComp implements Comparator<String>
{
    public int compare(String a, String b){
        return (a+b).compareTo(b+a) ;
    }
}
public class KnuthMorrisPattern {
 
    public static void main(String arp[])
    {
     //   matched("abiedbvjfivkopfdm", "kopd");
        ArrayList<Integer> al = new ArrayList<Integer> () ;
       al.add(45) ; 
        al.add(9) ;
        al.add(54) ;
       // al.add(45);
        System.out.println(largestNumber(al)) ;
    }
   
      public static  String largestNumber(final List<Integer> A) {
        String s = " "; 
         ArrayList <String> al = new ArrayList<String>() ;
        for(int i = 0 ; i < A.size(); i++)
          al.add(Integer.toString(A.get(i))) ;
        s = s.trim() ;
          Collections.sort(al, new myComp());
         // getPermutations(s, al);
          String maxi = "" ;
          
        //  int mod = (int)Math.pow(10,9)+7;
          for(String s1 : al)
           {
               //System.out.println(s1);
              
           maxi += s1;
           
           }
          
           return maxi ;
    }
    }
