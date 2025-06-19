// Time Complexity : O(log(m) + log(n)) == O(log(m*n)) where m is the number of rows and n is the number of columns
// Space Complexity : O(1) as nothing extra is created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I first used binary search to find the row in which the target could be present.
// Then I used binary search again to find the target in that row. 
// If the target is found, return true, else false.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0, rowHigh = matrix.length;
        int row = -1;
        while(rowLow<rowHigh){
            int midRow = (rowLow + rowHigh) / 2;
            if(matrix[midRow][0]<= target && matrix[midRow][matrix[0].length-1] >= target){
                row = midRow;
                break;
            }
            else if(matrix[midRow][matrix[0].length-1] > target) rowHigh = midRow;
            else rowLow = midRow+1;
        }
        if(row==-1)return false;
        int low = 0, high = matrix[row].length;
        while(low<high){
            int mid = (low+high)/2;
            if(matrix[row][mid] == target)return true;
            else if(matrix[row][mid]>target) high = mid;
            else if(matrix[row][mid]<target) low = mid+1;
        }
        return false;
    }
}