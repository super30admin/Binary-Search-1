
// 74. Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) 
            return false;
        
        int m= matrix.length; int n = matrix[0].length;
        int low = 0; int high = m*n -1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            int r = mid/n ; int c = mid % n;
            if( target == matrix[r][c]) 
                return true;
            else if(matrix[r][c] > target){
                high = mid - 1;
            }else
                low = mid + 1;
        }
       return false;
    }
}

// Complexity Analysis

/*
Time complexity : O(log(mn)) since it's a standard binary search.
Space complexity : 
O(1).
*/