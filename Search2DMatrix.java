// Time Complexity : O(n + log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1. Scanned through every row to see if target lies within the range of the row
//2. Once row/range was identified, performed binary search on it to search for target

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
        
        int row = matrix.length;
        int cols = matrix[0].length - 1;
        
        // O(n)
        for(int i = 0; i < row; i++) {
            if(target <= matrix[i][cols]) {
                return search(matrix[i], 0, cols, target);
            }
        }
        return false;
    }
    
    // O(log(n))
    private boolean search(int[] arr, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target) {
                return true;
            }
            else if(target > arr[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}