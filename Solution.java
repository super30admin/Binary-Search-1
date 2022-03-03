// Time Complexity : O(log(n)log(m))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int mid = -1;
        int idx = -1;
        
        // Binary Search on 0th indices of arrays to find which array, since they are given to be in sorted order
        while(start<=end){
            mid = (start + end)/2;
            if(target < matrix[mid][0]){
                end = mid - 1;
            }else if(target > matrix [mid][0]){
                start = mid + 1;
            }else{
                return true;
            }
        }
                
        idx = (start + end)/2;
        
        start = 1;
        end = matrix[idx].length - 1;

      // Binary Search on array from above to find the element
        while(start<=end){
            mid = (start + end)/2;
            if(target < matrix[idx][mid]){
                end = mid - 1;
            }else if(target > matrix [idx][mid]){
                start = mid + 1;
            }else{
                return true;
            }
        }        
        return false;
    }
}
