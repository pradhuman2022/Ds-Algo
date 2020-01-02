        import java.util.* ;
         
        public class MyCode{
           static long dpR[] ;
           static long dpW[] ; 
           //------------------------
           static long prefixR[] ; 
           static long prefixW[] ; 
           
           static int mod = (int)Math.pow(10, 9) + 7 ;
           
           public static void main(String arg[]){
              Scanner sc = new Scanner(System.in) ;
              
              int T = sc.nextInt() ; 
              int k = sc.nextInt() ;
              getWaysToEat(100000, k) ; 
              int a, b ; 
              
              while(T-->0){
                 a = sc.nextInt(); 
                 b = sc.nextInt() ; 
                 System.out.println((((prefixR[b] - prefixR[a - 1] + mod) % mod) + ((prefixW[b] - prefixW[a - 1] + mod) % mod)) % mod);    
              }
           }
           
           static void getWaysToEat(int b, int k){
              
              dpR = new long[b + 1] ; 
              dpW = new long[b + 1] ; 
              
              prefixR = new long[b + 1] ; 
              prefixW = new long[b + 1] ;
              
              prefixR[1] = 1 ; 
              
              dpR[1] = 1 ;
              //if lastFLower is Red which is first. 
              if(k == 1)
              {  dpW[1] = 1 ; prefixW[1] = 1 ; }
              
              //firstFLower can be white if k = 1.
              
              dpW[0] = 1 ;
              //if(i == k) then we need to count it as 1.
                
              
              for(int i = 2 ; i <= b ; i++){
                 
                 dpR[i] = ((dpW[i - 1] % mod) + (dpR[i - 1] % mod)) % mod ; 
                 if(i - k >= 0)
                 dpW[i] = ((dpR[i - k] % mod) + (dpW[i - k] % mod)) % mod ; 
                 
                 //calc prefix Sums 
                 prefixR[i] = ((prefixR[i - 1] % mod) + (dpR[i] % mod)) % mod ;  
                 prefixW[i] = ((prefixW[i - 1] % mod) + (dpW[i] % mod)) % mod ; 
              }
              
            //System.out.println(((prefixR[b] - prefixR[a - 1]) + (prefixW[b] - prefixW[a - 1])) % mod) ;    
            // for(int i = 1; i <= b; i++);
              ///System.out.println(dpR[i]+" "+dpW[i]) ; 
              
           }
           
           
        }
