import java.util.* ; 

public class MyCode{
   
   public static void main(String arg[]){
      Scanner sc = new Scanner(System.in) ; 
      int n = sc.nextInt() ; 
      ArrayList <Pair> p = new ArrayList <Pair>() ; 
      
      for(int i =  0 ; i < n ; i++){
         p.add(new Pair(sc.nextInt(), sc.nextInt())) ;
      }
      
      Collections.sort(p, (a, b) -> a.ft - b.ft) ; 
      int maxActivities[] = new int[n] ; 
      maxActivities[0] = 1 ; 
       int finalEndTime = p.get(0).ft ;  
      for(int i = 1 ; i < n; i++)
      {  
      if(p.get(i).st > finalEndTime)
      {
        maxActivities[i]  = maxActivities[i - 1] + 1 ;
        finalEndTime = p.get(i).ft  ;
      }
      else
          maxActivities[i] = maxActivities[i - 1] ;
      }


      int max = Integer.MIN_VALUE ;
      for(int i = 0 ; i < n; i++){
         max = Math.max(max, maxActivities[i]);
      }
      System.out.println(max);
   }
   
   static int findLatestNonConflict(ArrayList<Pair> p, int end, int startTime){
      int ans = -1 ; 
      
      int start = 0 ; 
      end = end - 1 ; 
      
      while(start <= end){
         int mid = (start + end) / 2  ;
         
         if(p.get(mid).ft < startTime)
            {
               //take decision
                if(p.get(mid + 1).ft >= startTime){
                   return mid  ;
                }else{
                   ans = mid ;
                   start = mid + 1 ; 
                }
            }else{
               end = mid - 1 ; 
            }
      }
      return ans ; 
   }
   
   static class Pair{
      int st ; 
      int ft ; 
      Pair(int s, int f){
         this.st = s ; 
         this.ft = f ; 
      }
   }
}
