class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;
        
        Job [] jobs = new Job[totalJobs]; 
        for (int i = 0 ; i < totalJobs; i++) {
            jobs[i] = new Job();
            jobs[i].startTime = startTime[i];
            jobs[i].endTime = endTime[i];
            jobs[i].profit = profit[i];
        }
        
        Arrays.sort(jobs, new Comparator<Job>(){
            public int compare(Job j1, Job j2) {
                return j1.endTime < j2.endTime ? -1 : j1.endTime == j2.endTime ? 0 : 1; 
            }    
        });
        int dp[] = new int[totalJobs]; 
        dp[0] = jobs[0].profit;
            
        for(int i = 1; i < totalJobs; i++) {
            int latestNonConflict = findNonConflict(i, jobs); 
            int maxProfit = jobs[i].profit ; 
            if(latestNonConflict != -1) 
                maxProfit = jobs[i].profit + dp[latestNonConflict] ; 
            dp[i] = Math.max(maxProfit, dp[i - 1]);
        }
        return dp[totalJobs - 1]; 
    }
    
    static int findNonConflict(int index, Job[]jobs) {
        int start = 0, end = index - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2; 
            
            if(jobs[mid].endTime <= jobs[index].startTime) {
                if(jobs[mid + 1].endTime <= jobs[index].startTime){
                    start = mid + 1; 
                }else 
                    return mid ; 
            }else 
                end = mid - 1; 
        }
        return -1; 
    }
    static class Job {
        int startTime; 
        int endTime;
        int profit;
    }
}
