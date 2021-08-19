// Time Complexity : log(m * n)
// Space Complexity : m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int probableRow = -1;
        boolean indexFound = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                if (matrix[i][n - 1] == target) {
                    indexFound = true;
                    break;
                } else {
                    probableRow = i;
                    break;
                }
            }
        }

        if (indexFound)
            return indexFound;

        if (probableRow < 0)
            return indexFound;
        else {
            /*
             * for (int i = 0; i < n; i++) { if (matrix[probableRow][i] == target) {
             * indexFound = true; break; }
             * 
             * }
             */
            indexFound = binarySearch(matrix[probableRow], 0, n, target);
        }
        return indexFound;
    }

    public boolean binarySearch(int arr[], int l, int r, int x) {
        int pivot = l + (r - l) / 2;

        if (x == arr[pivot]) {
            return true;
        } else if (x < arr[pivot] && pivot <= r) {
            return binarySearch(arr, l, pivot - 1, x);
        } else if (x > arr[pivot] && pivot <= r) {
            return binarySearch(arr, pivot + 1, r, x);
        } else
            return false;
    }

}