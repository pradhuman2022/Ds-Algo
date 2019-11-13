class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length ; 
        ArrayList<Job> jobs = new ArrayList<Job>() ; 
        
        
        for(int i = 0 ; i < n ; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i])) ; 
        }
        
        Collections.sort(jobs, new Comparator<Job>(){
            public int compare(Job l, Job k){
                if(l.et != k.et)
                    return l.et - k.et ;
                else{
                    if(l.profit != k.profit)
                        return k.profit - l.profit ;
                    else
                        return l.st - k.st ;
                }
            }
        }) ;
        
        int dp[] = new int[n] ; 
        dp[0] = jobs.get(0).profit ;
        
        for(int i = 1 ; i < n ; i++){
            
            Job curr = jobs.get(i) ; 
            
            int LRJ = getLastRecentAvailableJob(curr.st, jobs, i)  ;
            System.out.println(i+" "+LRJ+" "+curr.st+" "+curr.et) ; 
            int prevMaxProfit = LRJ < 0 ? 0 : dp[LRJ];
            System.out.print("NonConflict"+prevMaxProfit) ;
            dp[i] = Math.max(prevMaxProfit+curr.profit, dp[i-1]);
            System.out.print(" "+dp[i]+" "+i);
            System.out.println() ;
        }
        return dp[n - 1]  ;
    }
    int getLastRecentAvailableJob(int currStartTime, ArrayList<Job> jobs, int index) {
      
        int start = 0 ; 
        int end  = index - 1  ;
        int ans = -1;
        
        while(start <= end){
             int mid = (start + end) / 2 ;
             
            if(jobs.get(mid).et <= currStartTime)
            {
                if(jobs.get(mid + 1).et <= currStartTime)
                    start = mid + 1 ;
                else
                    return mid ;
            }
             else
                 end = mid - 1;
        }
        
        return ans ; 
    }
    class Job{
          int st ; 
          int et ;
          int profit ; 
        Job(int s ,int e , int p){
            this.st = s ; 
            this.et = e ;
            this.profit = p ;
        }
    }
}
