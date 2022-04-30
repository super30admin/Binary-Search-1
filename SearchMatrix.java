// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        int pivotId, pivotElement;
        while(left <= right) {
            pivotId = (left + right) / 2;
            pivotElement = matrix[pivotId / n][pivotId % n];
            if(target == pivotElement) {
                return true;
            }
            else if (target > pivotElement) {
                left = pivotId + 1;
            }
            else
                right = pivotId - 1;
        }
        return false;
    }
}