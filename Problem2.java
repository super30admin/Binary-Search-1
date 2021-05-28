// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * This solution is based on a finding that once we divide the rotated sorted array, we always have one half sorted
 * If target lies in sorted half, we search in that half else we search the other half.
 */


class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target) {
                return mid;
            }
            
            // case1
            // Right half is sorted
            if(arr[high] >= arr[mid]) {
                if(target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if(arr[mid] >= arr[low]) {
                // case 2
                // Left half is sorted
                if(target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }
}