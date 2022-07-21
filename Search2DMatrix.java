// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length, column = matrix[0].length - 1;

		for (int i = 0; i < row; i++) {
			// traverse through each row and apply binary search on each row if the target
			// less than or equal to the last elemnt of each row
			if (matrix[i][column] >= target) {
				return binarySearch(matrix[i], target, 0, column);
			}
		}

		return false;
	}

	private boolean binarySearch(int[] bar, int target, int start, int end) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (bar[mid] == target)
				return true;
			else if (bar[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return false;
	}
}