public class Solution {

    // Complete the highestValuePalindrome function below. .
    static String highestValuePalindrome(String s, int n, int k) {
       int arr[] = new int[s.length()] ; 
       for(int i = 0 ; i < arr.length ; i++)
       arr[i] = s.charAt(i) - '0' ;
       boolean visit[] = new boolean[n] ;

       int left = 0 ; 
       int right = n - 1 ;
       int moves = k ;
       for(;left <= right;)
       {
           if(arr[left] != arr[right])
           {
                if(arr[left] < arr[right])
                {
                    arr[left] = arr[right] ;
                    visit[left] = true ;
                }
                else
                {
                    visit[right] = true ;
                    arr[right] = arr[left] ;
                }
                k-- ;
                
           }
           left++ ;
           right-- ;
       }
       String ns = "";//new StringBuilder() ;
         for(int i = 0 ; i < arr.length ; i++)
             ns += Integer.toString(arr[i]) ;
             
       if(k <= -1)
        return "-1" ;
        
        left = 0 ; 
        right = n - 1 ;

        while(left <= right)
        {
            if(left == right && k >= 1)
               {
                   if(arr[left] < 9)
                   {
                   arr[left] = 9 ;
                   k-- ;

                   }
                   break ;
               }
            if(arr[left] < 9)
            {
                if(visit[left] == false && visit[right] == false && k >=2)
                {
                   
                    arr[left] = arr[right] = 9 ;
                    k -= 2 ;
                }
               
                if((visit[left] == true && visit[right] == false && k >= 1)||                   (visit[left] == false & visit[right] == true && k >= 1 ))
                {
                    arr[left] = arr[right] = 9 ;
                    k-- ;
                }
                
                
            } 
            left++;
            right-- ;  
        }
        StringBuilder str 
            = new StringBuilder(); 
        for(int x : arr)
         str.append(x);
        return str.toString() ;
    }
}
