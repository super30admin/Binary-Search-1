/** Time Complexity: O(log (m*n)) or O(log m + log n) (where n= number of elements in the row * number of columns)
* Space Complexity: O(1) [No extra space is used, only variables are used]
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
* LeetCode Problem: Search in 2D Matrix
* Approach:
* 1. Under the hood flatten the 2D matrix into a 1D array and perform binary search.
* Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int high=m*n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/n;
            int column=mid%n;
            if (matrix[row][column]==target)
            {
                return true;
            }
            if(matrix[row][column]<target)
            {
                low=mid+1;
            }
            if(matrix[row][column]>target)
            {
                high=mid-1;
            }
        }
    return false;
    }
}