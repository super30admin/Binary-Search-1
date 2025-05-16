// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// approach 
// Imagine the given 2D matrix as a 1D Array & calculate the mid of 1D array.
// We have mid index of 1D array , we have to convert into 2D array 
// Row and column of the 2d array is calculated as : row = mid / n ; col = mid % n  where n is size of the column 


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int rowc = mid/n;
            int colc = mid%n;
            if(matrix[rowc][colc]==target){
                return true;
            }
            if(target>matrix[rowc][colc]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
        
    }
}