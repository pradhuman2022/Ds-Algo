    import java.util.* ; 
     
    public class MyCode{
       
       public static void main(String arg[]){
          
          Scanner sc = new Scanner(System.in);
          
          int n = sc.nextInt() ; 
          int k = sc.nextInt() ; 
          
          int walks[] = new int[n] ; 
          for(int i = 0 ; i < n ;i++)
            walks[i] = sc.nextInt() ;
            
          findAdditionalWalks(walks, n, k) ;   
       }
       
         static void findAdditionalWalks(int w[], int n , int k){
              
              int dpWalks[] = new int[n] ; 
              dpWalks[0] = w[0] ; 
              int countWalks = 0 ; 
              for(int i = 1; i< n ; i++){
                 
                  dpWalks[i] =  Math.max(0, k - w[i] - w[i - 1]) ; 
                  w[i] += dpWalks[i] ; 
                  countWalks += dpWalks[i] ;
              }
           
            System.out.println(countWalks) ; 
            for(int walks : w)
             System.out.print(walks+" ");
            
         }
    }
