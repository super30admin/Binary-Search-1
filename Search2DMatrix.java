//TimeComplexity O(log(m*n))
//Space Complexity O(1)
//Yes


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int high = (m*n)-1;
        int low = 0;

        int mid = low + (high - low)/2;
        int row,col;
        while(low <= high) {
            mid = low + ((high - low)/2);
            row = mid/n;
            col = mid%n;
            if(matrix[row][col] == target)
                return true;
            
            else if(target > matrix[row][col]) 
                low = mid+1;
            
            else
                high = mid-1;

        }
        
        return false;
    }
}
