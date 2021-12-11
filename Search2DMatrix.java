//this is of time complextiy O(log m + log n)

// Time Complexity : O(log m + log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach - binary search on rows and columns
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int start = 0;
        int end = rows;
        
        int rowIndex = -1;
        //binary search to find the row
        while(start <= end) {
            int mid = start + ((end-start)/2);            
            if(mid >= rows) 
                break;
            if(target <= matrix[mid][columns-1] && target >= matrix[mid][0]) {
                rowIndex = mid;
                break;
            } else if(target > matrix[mid][columns-1]) 
                start = mid + 1;
            else 
                end = mid - 1;
        }
        if(rowIndex == -1) return false;
        
        //binary search to find the column
        start = 0;
        end = columns-1;
        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(mid >= columns)
                break;
            if(target == matrix[rowIndex][mid])
                return true;
            else if(target < matrix[rowIndex][mid])
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return false;
        
    }
}