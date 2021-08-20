// Time Complexity : O(m+log n) m=no.of rows in the matrix n= number of column integers in the matrix
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		// in case of single row matrix implementing binary search straight on that row.
		if (m == 1) {
			return binarySearch(matrix, 0, 0, n - 1, target);
		}
		// finding the row with its last element higher than the target so that we can
		// search for target in that row.
		for (int i = 0; i < m; i++) {
			if (matrix[i][n - 1] >= target) {
				if (matrix[i][n - 1] == target) {
					return true;
				}
				return binarySearch(matrix, i, 0, n - 1, target);
			}
		}
		return false;
	}

	// using binary search to search for the target once we find the row.

	boolean binarySearch(int arr[][], int row, int l, int r, int x) {
		int middle = (l + r) / 2;
		if (r < l) {
			return false;
		}
		if (x < arr[row][middle]) {
			return binarySearch(arr, row, l, middle - 1, x);
		}
		if (x > arr[row][middle]) {
			return binarySearch(arr, row, middle + 1, r, x);
		}
		if (x == arr[row][middle]) {
			return true;
		}
		return false;
	}
}