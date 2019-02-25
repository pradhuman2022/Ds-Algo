


import java.util.*;

 public class Main {

	static class Job
    {
      long StartTime ;
      long FinishTime ;
      long Profit ;
      Job(long St, long Ft, long p)
      {
        this.StartTime = St;
        this.FinishTime = Ft;
        this.Profit = p;
      }
      
     }
  
	 public static void main(String[] args) {
		// Write your code here
       Scanner sc = new Scanner(System.in) ;
       int n = sc.nextInt() ;
     // char c = 267;
       ArrayList <Job> Jobs = new ArrayList<Job> () ;
      
      while(n > 0)
      {
        Jobs.add(new Job(sc.nextInt(), sc.nextInt(), sc.nextInt())) ;
        n--;
      }
      
      FindMaxProfit(Jobs);
	}
  
  static void FindMaxProfit(ArrayList<Job> Jobs)
 
  {
    
  Collections.sort(Jobs, new Comparator<Job>(){
    public int compare(Job j1, Job j2)
    {
       Long jv1 = j1.FinishTime ;
       Long jv2 = j2.FinishTime ;
      return jv1.compareTo(jv2) ;
    } 
    });  
    
    long MaxProfit[] = new long[Jobs.size()] ;
    MaxProfit[0] = Jobs.get(0).Profit ;
    
    for(int i = 1 ; i < Jobs.size(); i++)
    {
        long AddValue = Jobs.get(i).Profit ;  
        int index = - 1;
        MaxProfit[i] = AddValue;
      int end = i ;
      int start = 0 ;
   
      
      label :while(start <= end)
      {
        int mid = (start + end) / 2 ;
       
        if((Jobs.get(i).StartTime >= Jobs.get(mid).FinishTime))
        {
      
          index = mid ;
          start = mid + 1 ;
        }
        
        else
        {
          end = mid - 1 ;
        }
       
        
      }
     
         
      if(index != -1)
      {
        MaxProfit[i] += MaxProfit[index];
      }  
     
        MaxProfit[i] = Math.max(MaxProfit[i], MaxProfit[i - 1]);
    }
    
   System.out.println(MaxProfit[Jobs.size() - 1]) ; 
    
    
  }

}
