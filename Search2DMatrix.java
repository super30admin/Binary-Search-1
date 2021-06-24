// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BST- search property. left subTree would be less than root value and right subTree values would be greater than root value
Hence taking a mid value and comparing it to the target value and checking either left half of the matrix or right and so on.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if(row == 0)
            return false;
        int col = matrix[0].length;

        //binary Search
        int left = 0, right = (row*col)-1;

        while(left <= right){
            int midpoint = (left+right)/2;
            int midElement = matrix[midpoint/col][midpoint%col];
            if(midElement == target){
                return true;
            }
            else if(midElement > target){
                right = midpoint-1;
            }
            else if(midElement < target){
                left = midpoint+1;
            }
        }
        return false;
    }
}