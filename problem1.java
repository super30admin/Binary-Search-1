// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {

public boolean searchMatrix(int[][] matrix, int target) {

    int row = matrix.length;

    if (row == 0){
        return false;
    }

    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    int pivotIndex, pivotElement;

    while (left <= right) {
        pivotIndex = (left + right) / 2;
        pivotElement = matrix[pivotIndex / col][pivotIndex % col];
        if (target == pivotElement){
            return true;
        } else {
            if (target < pivotElement)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
    }
    return false;
}
}