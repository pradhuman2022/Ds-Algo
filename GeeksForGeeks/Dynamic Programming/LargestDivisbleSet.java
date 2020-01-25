class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length ; 
        Arrays.sort(nums) ; 
        if(n == 0)
        {
            List<Integer> ans = new ArrayList<Integer>() ; 
            return ans ; 
        }
        Pair arr[] = new Pair[nums.length] ; 
        arr[n - 1] = new Pair() ; 
        arr[n - 1].value = nums[n - 1] ; 
        arr[n - 1].nextIndex = -1 ; 
        arr[n - 1].count = 1  ;
        
        for(int i = n - 2 ; i >= 0 ; i--){
            int next = -1 ; 
            arr[i] = new Pair() ; 
            arr[i].value = nums[i] ; 
            int countL = 0 ; 
            for(int j = i + 1 ; j < n ; j++)
            {
                if(nums[j] % nums[i] == 0)
                {
                    if(countL < arr[j].count)
                    {
                     
                        System.out.println(arr[j].count) ;
                         countL = arr[j].count ;
                         next = j ; 
                    }      
                   
                    
                }   
            }
            arr[i].nextIndex = next ; 
            arr[i].count = countL + 1 ; 
        }
      int start = 0 ;   
      int max = Integer.MIN_VALUE ; 
      for(int i = 0 ; i < n ; i++){
          if(arr[i].count > max){
              start = i ; 
              max = arr[i].count ; 
          }
      }
      //print
    List<Integer> subset = new ArrayList<Integer>() ; 
    for(int i = start ; i < n ;){
       if(i == -1)
           break ; 
     //   System.out.println(arr[i].value) ;
        subset.add(arr[i].value) ; 
        i = arr[i].nextIndex ; 
    }    
        
        return subset  ;
    }
    class Pair{
        int value ;
        int count ;
        int nextIndex ;  
      /*  Pair(int v, int c){
            value = v ; 
            count = c ;
        }*/
    }
}
