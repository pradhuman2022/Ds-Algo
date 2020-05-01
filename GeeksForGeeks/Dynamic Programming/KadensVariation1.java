class GfG
{       
    /*
     mene kadens lgaya but dhyan ni dia ki i to j ka maxSum chaiye hai
     or ek ko remove krke then baki sb include hone chaiye.
     gernalize kadens m hm sirf max sum nikalte hai.
    */
       public static int maxSumSubarray(int A[], int n)
         {
             //add code here.
             int preKadens[] = new int[n];
             int postKadens[] = new int[n]; 
             
             int currentSum = A[0] ;
             int maxSum = A[0]; 
             preKadens[0] = A[0]; 
             
             for (int i = 1; i < A.length; i++) {
                 currentSum = Math.max(A[i], currentSum + A[i]) ; 
                 maxSum = Math.max(maxSum, currentSum);
                 preKadens[i] = currentSum; 
             }
             
            postKadens[n - 1] = A[n - 1];
            currentSum = A[n - 1];
            maxSum = A[n - 1]; 
            for(int i = A.length - 2; i >= 0; i--) {
                currentSum = Math.max(A[i], currentSum + A[i]) ; 
                maxSum = Math.max(maxSum, currentSum);
                postKadens[i] = currentSum;
            } 
            int ans = maxSum; 
            for(int i = 0; i < A.length; i++) {
                if(i == 0)
                    ans = Math.max(ans, postKadens[i + 1]);
                else if(i == A.length - 1)
                    ans = Math.max(ans, preKadens[i - 1]);
                else
                    ans = Math.max(ans, preKadens[i - 1] + postKadens[i + 1]); 
            }
            return ans; 
             
         }
}

