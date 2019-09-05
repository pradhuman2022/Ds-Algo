class Solution {
   public int kthSmallest(int[][] matrix, int k) {
	        int ans = -1 ;
	        Queue<pair> pq = new PriorityQueue<pair>((a, b)-> a.value - b.value) ;
	        for(int i = 0 ; i < matrix.length ; i++)
	        {
	        	pq.offer(new pair(matrix[i][0], i, 0)) ;
	        }
	        
	        while(k-- > 0)
	        {
	        	pair p = pq.poll() ;
	        	if(p.col < matrix.length - 1)
	        		 pq.add(new pair(matrix[p.row][p.col + 1], p.row, p.col + 1)) ;
	        	
	        	ans = p.value ;
	        }
	        return ans ;
	        
	    }
	  static class pair
	  {
		  int value ;
		  int row ; 
		  int col;
		  pair(int v, int r, int c)
		  {
			  value = v ; 
			  row = r ; 
			  col = c ;
		  }
	  }
	}
