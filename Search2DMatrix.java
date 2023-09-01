// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/search-a-2d-matrix/submissions/1037899380/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Use the binary search algorithm, to find the element in O(logn) time
 * Search the array, assuming it is flattened, and apply the binary search algorithm in finding the element
 * Find the row and col values using row = mid/n, col = mid%n
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =  matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n -1;
        while(low <= high){
            int mid = low+(high-low)/2; //to prevet
            int row = mid/n; // this helps in getting the value from 2D matrix directly without flattening the array
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}