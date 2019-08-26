import java.util.* ;
public class KnightGraph {
       
	   public static void main(String ar[])
	   {
		   Scanner sc = new Scanner(System.in) ;
		   int T = sc.nextInt() ;
		   while(T-- > 0)
		  {
		   int n = sc.nextInt() ;
		   int r = sc.nextInt();
		   int c = sc.nextInt(); 
		   int d1 = sc.nextInt() ;
		   int d2 = sc.nextInt() ;
		   System.out.println(minSteps(n ,r, c, d1, d2));
		  }
		   //System.out.println(minSteps(n ,r, c, d1, d2));
		   
	   }
	
	  static int minSteps(int n, int r, int c , int d1 , int d2)
	  {
		  int moves = 0 ;
		  int x = r ; 
		  int y = c ;
		  int dx[] = new int[]{-1 , 1, 2, 2 , 1, -1, -2, -2} ;
		  int dy[] = new int[]{-2, -2, -1, 1, 2, 2, 1, -1} ;
		  Queue<Pair> q = new ArrayDeque() ;
		  q.offer(new Pair(x, y)) ;
		  boolean mat[][] = new boolean[n + 1][n + 1] ;
		  while(!q.isEmpty())
		  {
			  Pair currPos = q.poll() ;
			  if(currPos.x == d1 && currPos.y == d2)
				  break ;
			  if(!mat[currPos.x][currPos.y])
			  {
				 // mat[currPos.x][currPos.y] = true ;
				  
				  for(int i = 0 ; i < dx.length ; i++)
				  {
					  if(isValid(currPos.x + dx[i], currPos.y + dy[i], n)&&mat[currPos.x + dx[i]][currPos.y + dy[i]] == false)
					  {
						  q.add(new Pair(currPos.x + dx[i], currPos.y + dy[i])) ;
						  mat[currPos.x + dx[i]][currPos.y + dy[i]] = true ;
					  }
				  }
				 
			  }
			  moves++;
			  System.out.println("dmdmvdmlmd"+moves);
		  }
		  
		  return moves ;
	  }
	 static boolean isValid(int x, int y , int n)
	 {
		 if(x >=1 && x <= n && y >=1 && y <= n )//x < 1 || y < 1)
			 return true;
		 return false ;
	 }
	  
	  
	  static class Pair
	  {
		  int x ; 
		  int y ; 
		  Pair(int x , int y)
		  {
			  this.x = x ; 
			  this.y = y ;
		  }
	  }
	
}
