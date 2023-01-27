// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * This is a linear solution. In this, we start from one corner of the matrix.
 * if the element in that corner is equal to target, return true. else check if 
 * it is less than target, if so, increment the column index position, if it is greater
 * than target, decrement row index position. this happens until row and column indices
 * are not out of bound. Every time indices are updated check if the element in that index
 * is the target to return true else return false at the end. This is not efficient compared
 * to binary search.
 *
 */
class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i = matrix.length - 1, j = 0;
//        while(i >= 0 && j <= matrix[0].length - 1) {
//            if(matrix[i][j] == target)
//                return true;
//            else if(matrix[i][j] < target)
//                j++;
//            else
//                i--;
//        }
//        return false;
//    }
	
	/**
	 * This is binary search approach. In this, take left as 0th index,
	 * right as the m*n - 1 which is the last index of the matrix. Find the mid
	 * of left and right. if the mid element is target, return true. Else if
	 * target is greater than mid element, make left as mid + 1 position else
	 * right as mid - 1 position. If target not found before left <= right, then
	 * return false. The formula to find the row and column using column length is
	 * Row = mid / n, Col = mid % n
	 */
	
	// Time Complexity : O(log(MN))
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : None
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            int element = matrix[mid / n][mid % n];
            if(target == element)
                return true;
            else if(element < target) 
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}