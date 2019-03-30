public class Main
{
    static int visit[] ;
    public static void main(String[] args) {
        
        
        int n = 4 ; 
        visit = new int[4] ; 
        int js[][] = new int[][]{ {10,9,12},
        {5,8,13},
        {4,7,10},
        {2,6,1}
        } ; 
        System.out.println(maxWorth(2,1,1,js)) ;
        
}

static int maxWorth(int gold , int silv, int plat ,int js[][])
{
  int result = Integer.MIN_VALUE ;    
  if(gold <= 0 && silv <= 0 && plat <= 0)
    return 0 ;
   
   for(int i = 0 ; i < js.length ; i++)
     {
         if(visit[i] == -1)
           continue ;
         visit[i] =-1 ;
         result = Math.max(result, js[i][0]+maxWorth(gold - 1 , silv, plat , js)) ;
         visit[i] = 0 ;
     }
     for(int i = 0 ; i < js.length ; i++)
     {
         if(visit[i] == -1)
           continue ;
         visit[i] = -1 ;
         result = Math.max(result, js[i][1] + maxWorth(gold, silv - 1, plat , js)) ;
         visit[i] = 0 ;
     }
       for(int i = 0 ; i < js.length ; i++)
     {
         if(visit[i] == -1)
           continue ;
         visit[i] = -1 ;
         result = Math.max(result, js[i][2] + maxWorth(gold, silv, plat - 1 , js)) ;
         visit[i] = 0 ;
     }
     return result ;
    
}

}


