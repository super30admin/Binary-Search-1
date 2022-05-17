// Time Complexity : O(logmn) since standard binary search with m rows and n columns
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols - 1; // last element
        
        int middleIndex;
        int middleElement;
        
        while (left <= right){
            middleIndex = (left + right) / 2; // middle index
            middleElement = matrix[middleIndex / cols][middleIndex % cols]; // get corresponding element at middle index
            if (target == middleElement){
                return true;
            }
            else if (target < middleElement){
                right = middleIndex - 1;
            }
            else { // target > middle
                left = middleIndex + 1;
            }
        }
        
        return false;
    }
}