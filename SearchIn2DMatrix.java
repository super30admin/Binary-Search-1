class SearchIn2DMatrix{
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No



    /*
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
     */

    /*
      Approach - 1: we need to check for start element of row.
      1. if the start element is greater then there is no need to enter the row at all
      2. if the row element is smaller than target, then check the that row by comparing value
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length-1, col = 0;

        while (row >= 0 && col < matrix[0].length){

            if (matrix[row][col] > target){
                row --;
            }
            else if(matrix[row][col] < target){
                col++;
            }
            else {
                //found the element.
                return true;
            }
        }

        return false;
    }

}
/*
LeetCode analysis:

135 / 135 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 38.9 MB
 */

//There is one more approach where we can use binary search to find the whether the row qualifies
//to implement binary search on its coloums...tc of that approach is better than this approach
//main reason why i used this approach is this is common approach for both questions: Search in Matrix 2D-1 and 2.
