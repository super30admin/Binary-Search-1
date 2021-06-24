// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem1;

public class Search2D {
	int[][] arr;

	public Search2D() {
	}

	public Search2D(int[][] arr) {
		this.arr = arr;
	}

	/*
	 * Start with first row last column or last row first column. This way, you will
	 * have 2 directions you can go in, to find the target element. Perform binary
	 * search.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}

		int row = 0;
		int col = matrix[0].length - 1;

		while (row <= matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Search2D obj = new Search2D();
		int[][] arr = {
				{1,2,3,7},
				{11,14,16,24},
				{29,30,45,57},
				{60,76,89,91}
		};
		
		System.out.println("Searching for element 15 -- "+ (obj.searchMatrix(arr, 15) ? "Found" : "Not Found"));
		System.out.println("Searching for element 30 -- "+ (obj.searchMatrix(arr, 30) ? "Found" : "Not Found"));
	}
}
