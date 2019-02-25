import java.util.* ;
public class ListCarry 
{
    
        public static void main (String arg[])
{
  
ArrayList <Integer> al = new ArrayList() ;
al.add(9);
al.add(9);
al.add(9);
al.add(9);
al.add(9);
System.out.println(ans(al)) ;

}
  static  ArrayList<Integer> ans(ArrayList<Integer> al)   
          {
        
              int carry = 0 ;
              int i = 0  ;
              while(al.get(i) == 0 && i < al.size())
              {
                  al.remove(i) ;
                  i++ ;
              }
              
             for(int k = al.size() - 1 ; k >= 0; k--)
             {
                 int sum = al.get(k) + 1;
                 al.set(k , sum % 10) ;
                 carry = sum / 10 ; 
                 if(carry == 0)
                     break;
             }
              if(carry == 1)
                  al.add(0, carry) ;
              
              
              return al ;
          }   
}
