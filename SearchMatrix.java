// Time Complexity : The time complexity is O(log(mn)) where m is the number of rows and n is the number of columns because for every
// iteration the search space is reduced by half
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;

        if(rows == 0){
            return false;
        }

        int columns = matrix[0].length;

        if(columns == 0){
            return false;
        }

        // Consider the 2D array as a 1D array
        int start = 0;
        int end = rows*columns-1;

        while(start <= end){

            int mid = (end-start)/2 + start;

            // Converts the mid index in the form of row and column
            int row = mid / columns;
            int column = mid % columns;

            // If the target is found, return
            if(matrix[row][column] == target){
                return true;
            }
            // If target is less than mid, search in the left part of the array
            else if(matrix[row][column] > target){
                end = mid-1;
            }
            // If target is greater than mid, search in the right part of the array
            else{
                start = mid+1;
            }

        }

        return false;

    }

}
