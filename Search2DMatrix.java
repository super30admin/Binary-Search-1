class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colLength = matrix.length;
        int rowLength = matrix[0].length;
        int low = 0;
        int high = colLength-1;
        int mid;

        while(low<=high){
            mid = low + (high-low)/2;

            if(matrix[mid][rowLength-1] == target)
                return true;
            else if(matrix[mid][rowLength-1] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if(low>=colLength)
            return false;
        int row = low;

        low = 0;
        high = rowLength - 1;
        while(low<=high){
            mid = low + (high-low)/2;

            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}