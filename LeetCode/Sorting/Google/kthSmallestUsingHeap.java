class Solution {
public int kthSmallest(int[][] matrix, int k) {

		`Queue<Integer> pq = new PriorityQueue<Integer>((a, b)-> -a + b) ;
        for(int i = 0 ; i < k ; i++)
        {
            int currentColumn = i % (matrix[0].length);
            int currentRow = (i - currentColumn) / (matrix[0].length);
        	pq.add(matrix[currentRow][currentColumn]);
        }
        
       for (int i = k; i < matrix.length * matrix[0].length; i++) {
           
           int currentColumn = i % (matrix[0].length);
           int currentRow = (i - currentColumn) / (matrix[0].length);
           
           if (matrix[currentRow][currentColumn] < pq.peek()) {
               pq.poll();
               pq.add(matrix[currentRow][currentColumn]);
           }
       }
   
        return pq.peek() ;
}
}

