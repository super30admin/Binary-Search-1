// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Calculation of mid, low and high at proper place.


// Your code here along with comments explaining your approach

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		 int n = matrix.length;
		 int m = matrix[0].length;
		 
		 int low = 0;
		 int high = m*n-1;
		 
		 int mid;
		 int row = 0, col = 0;
		 while(low <= high) {
			  mid = low+(high-low)/2;
			  row = mid/m;
			  col = mid%m;
			  if (matrix[row][col] == target) return true;
			  if (matrix[row][col] > target) {
					high = mid - 1;
			  } else {
					low = mid + 1;
			  }
		 }
		 return false;
	}
}