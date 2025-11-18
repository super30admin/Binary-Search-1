// Time Complexity : O(log Rows + log Cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : first i did O(R+C) appraoch
// and then i did binary search on columns so that was O(R) + O(log C)
// abd then i did binary search on rows too and col so O(log R) + O(log C)


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int possibleRow = -1;
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int top = 0, bottom = rows;
        while(top <= bottom)
        {
            int mid = top + (bottom - top)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][cols])
            {
                possibleRow = mid;
            }
            if(matrix[mid][0] > target)
            {
                bottom = mid - 1;
            }
            else
            {
                top = mid+1;
            }
        }
        
        if(-1 == possibleRow) return false;
        
        int left = 0, right = cols;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(matrix[possibleRow][mid] == target)
            {
                return true;
            }
            if(matrix[possibleRow][mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return false;
    }
}