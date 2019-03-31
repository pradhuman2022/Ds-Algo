import java.util.* ; 
class HasanAndTrip
{
  public static void main(String args[])
  {
      Scanner sc = new Scanner(System.in) ;
      int n = sc.nextInt() ;
      City [] cities = new Cities[n + 1] ; 
      for(int i = 1 ; i <= n ; i++)
        cities[i]= new City(sc.nextInt(), sc.nextInt(), sc.nextInt()) ;
      int dp[] = new int[n + 1];  
      dp[1] = cities[1].h ; 
      for(int i = 2 ; i <= n ; i++)
      {
         dp[i] = Integer.MIN_VALUE :
         for(int j = 1 ; j < i ; j++)
        dp[i] = Math.max(dp[i], dp[j] + cities[i].h + getDistance(cities[i], cities[j])) ; 
        }
        System.out.println(System.format("%.6f"dp[n])) ; 
   }
   static class City
   {
   int x ;
   int y ;
   int h ;
   public City(int x, int y , int h)
   {
     this.x = x ; 
     this.y = y ;
     this.h = h ;
   }
   }
}
