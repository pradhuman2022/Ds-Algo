                import java.util.* ;
                 
                public class MyCode{
                   
                   public static void main(String ar[]){
                      
                      Scanner sc = new Scanner(System.in);
                      
                      int n = sc.nextInt() ; 
                      int c[] = new int[100001] ; 
                      int max = Integer.MIN_VALUE ; 
                      
                      for(int i = 0; i < n ; i++)
                      {
                         int coins = sc.nextInt() ; 
                         max = Math.max(max, coins) ;
                         c[coins]++ ; 
                      }
                      for(int i = 1 ; i < 100001 ; i++)
                          c[i] += c[i - 1] ; 
                      
                      int q = sc.nextInt() ; 
                      
                      
                      for(int i = 0 ; i < q ; i++)
                      { 
                        int k = sc.nextInt() ; 
                        if(k >= max)
                          System.out.println(n) ; 
                         else 
                       System.out.println(c[k]) ;
                   }
                   }
                   
                   
                }
