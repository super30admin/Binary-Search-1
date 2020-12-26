package search2dmatrix;// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Just getting started


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //return false if there is no matrix
        if(matrix[0].length == 0) return false;

        //Get length of row and column
        int rows = matrix.length;
        int cols = matrix[0].length;

        //get values for low and high index
        int lowIndex = 0;
        int highIndex = rows * cols -1;

        while(lowIndex <= highIndex){
            int midPoint = lowIndex + (highIndex - lowIndex)/2; //Getting midpoint with this formula to avoid int overflow
            int midpointElement = matrix[midPoint/cols][midPoint%cols]; // get the midpoint element

            //search using binary search
            if(midpointElement == target){
                return true;
            } else if(target < midpointElement){
                highIndex = midPoint -1;
            } else if (target > midpointElement){
                lowIndex = midPoint + 1;
            }
        }
        return false; // return false if not found
    }
}