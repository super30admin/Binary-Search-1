// Time Complexity : O(log m.n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n =matrix[0].length;
        boolean found = false;
        for(int i = 0; i< m; i++) {
            if(target<matrix[i][n-1]) {
                found = (binarySearch(matrix[i], target) !=-1);
                return found;
            }
            else if (target > matrix[i][n-1]) {
                continue;
            }
            else {
                return true;
            }
        }
        return found;
        
    }
    
    private  int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid  = left + (right - left) / 2;
            if(arr[mid] > target) {
                right = mid-1;
            } else if(arr[mid] < target) {
                left  = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}