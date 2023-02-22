// Time Complexity : o log(m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
// as problem says rows are sorted and first integer is next row is greater than the last integer of previous 
// start checking from top left element and move left if element is greater than target
// and move down if element is less than target

public class SearchA2dMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		// target3
		int i = 0;
		int j = n - 1;

		while (i < m && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {// 3
				j--;
			} else if (matrix[i][j] < target) { // 11
				i++;
			}
		}
		return false;
	}
}
