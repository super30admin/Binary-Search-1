// Time Complexity : O(log m + log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/**
 * 1. Find the row where the element range might exist
 * 2. run binary search on that row for an element
 */

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		return findRow(matrix,0,matrix.length-1, target);

	}

	private boolean findRow(int[][] matrix,int l,int r, int target) {
		if (matrix.length > 0) {
			int subLen = matrix[0].length;
			
			int mid= l+(r-l) /2;

			if(l>r) {
				return false;
			}
			else if (matrix[mid][0] <= target && matrix[mid][subLen - 1] >= target) {
				return binarySearch(matrix[mid], 0, subLen - 1, target);				
			}else if (matrix[mid][0] > target) {
				return findRow(matrix, l, mid - 1, target);				
			}else {
				return findRow(matrix, mid +1,r, target);
			}
			
		}
		return false;
	}

	public boolean binarySearch(int[] arr, int l, int r, int target) {
		if (l > r) {
			return false;
		}
		int mid = l + (r - l) / 2;
		if (arr[mid] == target) {
			return true;
		} else if (arr[mid] > target) {
			return binarySearch(arr, l, mid - 1, target);
		} else {
			return binarySearch(arr, mid + 1, r, target);
		}
	}
}

public class Search2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { {1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(new Solution().searchMatrix(matrix, 61));
	}
}
