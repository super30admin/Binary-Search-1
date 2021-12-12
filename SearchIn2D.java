/*
Time complexity: O(logmn) as we are doing binary search on the all elemeents
Space complexity: O(1)
so here we are tal=king entire array as a list of array
**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length - 1;
        int n = matrix[0].length;
        while (low <= high) {
            int pivot = low + (high - low) / 2;

            int elementAtPivot = matrix[pivot / n][pivot % n];

            if (elementAtPivot == target) {
                return true;
            } else if(elementAtPivot < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        return false;

    }
}