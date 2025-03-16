// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: We can consider the 2D matrix as a 1D array and apply binary search on it. We can find the mid element and compare it with the target element. If the mid element is equal to the target element, we can return true. If the mid element is greater than the target element, we can search in the left half of the array. If the mid element is less than the target element, we can search in the right half of the array. We can repeat this process until we find the target element or the low pointer is greater than the high pointer. If we don't find the target element, we can return false.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low=0;
        int high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int midValue = matrix[mid/n][mid%n];
            if(midValue == target){
                return true;
            }
            else if (midValue> target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
        
    }
}