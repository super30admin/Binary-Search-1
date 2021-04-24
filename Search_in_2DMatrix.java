class Solution {
    //Time O(logN)
    //Space O(1)
/*
*Imagine it as 1D matrix and perform the binary search as if
*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;
        int low = 0 , high = m*n-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
            {
                return true;
            }
            if(matrix[row][col] < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}