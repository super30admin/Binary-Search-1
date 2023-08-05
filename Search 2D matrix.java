// Use pivot index to divide 2D array into two halfles and use pivot index and elemnt to track 
// Base on target vs. pivot element --> determine where target could be
// Time Complexity: O(log m*n) (searching row and column enable a linear search of m row and n column bases on pivot)
// Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0) return false;
        
        // now start binary search
        int left = 0;
        int right = m * n - 1;
        int pivotIndex, pivotElement;
        while (left<= right) {
            pivotIndex = (left + right) / 2;
            pivotElement = matrix[pivotIndex / n][pivotIndex % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIndex - 1;
                else left = pivotIndex + 1;
            }
        }
        return false;
    }
}
