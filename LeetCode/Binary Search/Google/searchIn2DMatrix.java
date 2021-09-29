class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = Math.min(matrix[0].length, matrix.length);
        
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        for (int i = 0; i < min; i++) {
            if (binarySearch(matrix, i, true, target) || binarySearch(matrix, i, false, target))
                return true;
        }
        
        return false;
    }
    
    public boolean binarySearch(int matrix[][], int start, boolean vertical, int target) {
        
        int low = start;
        int high = vertical ? matrix[0].length - 1: matrix.length - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            if (vertical) { // columns
                
                if(matrix[start][mid] > target)
                    high = mid - 1;
                else if (matrix[start][mid] < target)
                    low = mid + 1;
                else 
                    return true;
                
            } else { // row
                
                if(matrix[mid][start] > target)
                    high = mid - 1;
                else if (matrix[mid][start] < target)
                    low = mid + 1;
                else 
                    return true;
            }
        }
        
        return false;
    } 
}
