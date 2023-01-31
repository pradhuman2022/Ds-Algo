class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int start = 0;
        while(row >= 0) {
            start = binarySearch(start, row, matrix, target);
            if (matrix[row][start] == target)
                return true;
            row--;
        }
        return false;
    }

    public int binarySearch (int start, int row, int matrix[][], int target) {
        int end = matrix[0].length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }   
}
//O(RlogC)
