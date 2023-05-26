package BinarySearch;
/*
 * Here we perform two binary searches.One to find the correct row and the second one to search target within that row.
 *
 * Time Complexity :
 * Log(m)+Log(n)
 * 
 * Space Complexity :
 * Space complexity is O(1)
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */

public class Problem1 {
	
	public static void main(String args[]) {
		Problem1 p = new Problem1();

//		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int[][] matrix = { { 1}, {3}};

		System.out.println(p.searchMatrix(matrix, 4));

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int targetRow;
		if (matrix.length > 1) {
			//return the row where element can be found
			targetRow = binarySearch(matrix, target, 0, matrix.length - 1);
			if (targetRow == -1) {
				return false;
			}

			if (matrix[targetRow][matrix[targetRow].length - 1] == target)
				return true;
		} else
			targetRow = 0;
		//return col where elemnt is found or -1
		int targetCol = binarySearch(matrix[targetRow], target, 0, matrix[targetRow].length - 1);

		if (targetCol != -1)
			return true;
		else
			return false;
	}

	int binarySearch(int[][] matrix, int target, int low, int high) {
		//slighty modified binary search to find the target row. Here instead searching of element itself we just check if target can exist within that particular row
		int middleRow = (high + low) / 2;
		if(low>high) {
			return -1;
		}
		if (matrix[middleRow][matrix[0].length - 1] >= target && target>=matrix[middleRow][0])       {    
			return middleRow;
		} else if (target < matrix[middleRow][0]) {
			return binarySearch(matrix, target, low, middleRow - 1);
		} else
			return binarySearch(matrix, target, middleRow + 1, high);

	}

	int binarySearch(int[] matrix, int target, int low, int high) {
		//classic binary search
		int middleCol = (high + low) / 2;

		if (low > high) {
			return -1;
		}

		if (matrix[middleCol] == target) {
			return middleCol;
		} else if (target < matrix[middleCol]) {
			return binarySearch(matrix, target, low, middleCol - 1);
		} else
			return binarySearch(matrix, target, middleCol + 1, high);

	}


}
