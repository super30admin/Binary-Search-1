// # Binary-Search-1


// ## Problem1 
// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;

        //binary search
        int left = 0;
        int right = m * n - 1;
        int pivot_idx, pivotElement;
        while(left <= right){
            //calculating mid 
        pivot_idx = (left + right) / 2;
        pivotElement = matrix[pivot_idx / n][pivot_idx % n];

        // int row = pivot_idx /n;
        // int col = pivot_idx % n;

        if(target == pivotElement )
            return true;
        else {
            if (target < pivotElement)
                right = pivot_idx -1;
            else 
                left = pivot_idx +1;

        }
        }
        
        return false;
    }
}