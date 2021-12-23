package binarySearch1;

public class SearchA2DMatrix {
	// Time Complexity : O(log n)
	// Space Complexity : o(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Finding the equivalent value to mid from the matrix
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m * n - 1;
        
        while(i <= j) {
            int mid = i + (j - i) / 2;
            int val = matrix[mid/n][mid%n];
            if(target == val)
                return true;
            else if(target < val)
                j = mid - 1;
            else
                i =  mid + 1;
        }
        
        return false;
    }
}
