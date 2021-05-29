// Time Complexity : O(log m + log n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/**
 * 1. Find the row where the element range might exist 2. run binary search on
 * that row for an element
 */

class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
		int totalRows= matrix.length;
		if (totalRows == 0)
			return false;
		int totalCols = matrix[0].length;

		// binary search
		int left = 0, right = (totalRows * totalCols) - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = left + (right-left) / 2;
			pivotElement = matrix[pivotIdx / totalCols][pivotIdx % totalCols];
			if (target == pivotElement)
				return true;
			else {
				if (target < pivotElement)
					right = pivotIdx - 1;
				else
					left = pivotIdx + 1;
			}
		}
		return false;
	}
}

public class Search2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		System.out.println(new Solution().searchMatrix(matrix, 61));
	}
}
