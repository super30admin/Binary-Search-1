// Time Complexity : O(log(m*n))
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int tmp=0;
        if(matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        // treat the 2D matrix as a sorted list, can be solved using one binary search loop
        int r=matrix.length, c=matrix[0].length, mid;
        int low = 0, high = r*c-1;
        while(low <= high){
            mid = low+ (high-low)/2;
            if(matrix[mid/c][mid%c] == target){
                return true;
            }
            else if(matrix[mid/c][mid%c] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
