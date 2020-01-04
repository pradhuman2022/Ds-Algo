public class HelloWorld{

     public static void main(String []args){
      Stack<Integer> st = new Stack<Integer> () ;
      st.push(10);
       st.push(9);
        st.push(8);
         st.push(7);
          st.push(6);
          System.out.println(st) ;
          Reverse(st) ;
          System.out.println(st) ;
     }
     static void Reverse(Stack<Integer>st)
     {
         if(st.isEmpty())
         return ; 
         
         int a = st.pop() ;
         Reverse(st) ;
         insert_At_Bottom(st, a) ;//inserting current at bottom
     }
     static void insert_At_Bottom(Stack<Integer> st, int a)
     {
       if(st.size() == 0)
         st.push(a) ;
      else
        {
           int k = st.pop() ; 
           insert_At_Bottom(st, a);
           st.push(k);
        }
        
       } 
         
}
