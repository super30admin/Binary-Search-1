// Considering the 2D matrix as a sorted array instead, and then implementing Binary Search.
// Time complexity: O(log(m * n))
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class Search2DMatrix {
public boolean searchMatrix(int[][] matrix, int target) {
			int m = matrix.length;
			int n = matrix[0].length;
			int low = 0;
			int high = m * n - 1;
			//boolean ans = false;

			while (low <= high) {
				int mid = (low + high) / 2;
				if (matrix[mid / n][mid % n] == target)
	                return true;
	            else if (matrix[mid / n][mid % n] > target)    
	                high = mid - 1;
	            else
	                low = mid + 1;   
			}
			return false;
	     }
}
