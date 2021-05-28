// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// Think about the 2D array as a 1D array of size m*n
// then calculate the middle using the low and high pointers
// use the middle to calculate the indices in the 2D array
// compare the value of target with the value at the indices in 2D array
// change the low and high accordingly and perform Binary Search till you find the target or reach the exit condition

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length)*(matrix[0].length)-1;
        
        while(low<=high) {
            int mid = low + (high - low)/2;
            int pivot = mid / matrix[0].length;
            int pivot2 = mid % matrix[0].length; 

            if(matrix[pivot][pivot2] == target) {
                return true; 
            }
            
            if(matrix[pivot][pivot2] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}