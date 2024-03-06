//time: O(logm + logn), log m for finding the row and logn for finding the element in the row
//space: O(1)
//approach: Binary search

class Solution {
    int m;
    int n;
    int globalMid;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        if (matrix == null || matrix.length == 0) return false;
        //in case of only one element
        if(matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }
        //in case of only one row
        if(matrix.length == 1) {
            return searchOnRow(0, matrix, target);
        }
        globalMid = -1;
        int top = 0;
        int bottom = m -1;
        //first find the row using binary search
        while (top <= bottom) {
            int mid = (bottom - top)/2 + top;
            if(matrix[mid][0] == target || matrix[mid][n-1] == target) return true;
            if (matrix[mid][0] < target && target < matrix[mid][n-1]) {
                //binary search on mid-th row
                globalMid = mid;
                break;
            } else if (target > matrix[mid][0]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            }
        }
        if (globalMid != -1) {
            return searchOnRow(globalMid, matrix, target);
        }
        return false;
    }
    
    //one row is found, find the target element using binary search
    private boolean searchOnRow(int mid, int[][] matrix, int target) {
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int middle =  (right-left)/2 + left;
            if (matrix[mid][middle] == target) {
                return true;
            } else if (matrix[mid][middle] > target) {
                right = middle - 1;
            } else if (matrix[mid][middle] < target) {
                left = middle + 1;
            }
        }
        return false;
    }
}
