import java.util.* ;

public class WomansDay {
  
   public static void main(String arg[]){
     
    Scanner sc = new Scanner(System.in) ;
    int n = sc.nextInt() ;
    int k = sc.nextInt() ;
    long candies[] = new long[n] ; 
    for(int i = 0 ; i < n; i++)
    {
     candies[i] = sc.nextInt() ;   
    }
    long maxGifts = 0 ;
    
    long strFreq [] = new long[k] ;
    for(int i = 0; i < n ; i++)
    {
            strFreq[(int)candies[i] % k]++;
    }
    
    for(int i = 1 ; i <= k / 2; i++)
    {
        if(strFreq[i] != 0 && strFreq[k - i] != 0 && i != k - i)
        {
          maxGifts = Math.min(strFreq[i], strFreq[k - i]) ;
        }
        else if(strFreq[i] != 0 && strFreq[k - i] != 0 && i == k - i)
        {
          maxGifts += strFreq[i] / 2 ;
        }      
    }        
   maxGifts += strFreq[0] / 2 ;  
  
    System.out.println(maxGifts * 2) ;
  
}

   
}
