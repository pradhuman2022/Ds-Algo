class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       
       Arrays.sort(arr, new Comparator<Pair>(){
          public int compare(Pair a, Pair b)
           { 
               return a.x - b.y ;
           }
           });
       
       int dp[] = new int[n] ; 
       
       for(int i = 0 ; i < n ; i++){
           dp[i] = 1 ; 
           for(int j = i - 1 ; j >= 0; j--){
               if(arr[i].x > arr[j].y)
                 dp[i] = Math.max(dp[i], dp[j] + 1) ;
           }
       }
       
       int max = Integer.MIN_VALUE ;
       
       for(int k : dp)
         max = Math.max(k, max) ;
    
       return max ;
     
    }
}
