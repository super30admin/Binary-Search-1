// Time Complexity : O(log n) basically doing binary search based on ascending sub-array
// Space Complexity : O(1) in addition to the provided array which O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really

class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        return performSearch(nums, left, right, target);
    }
    
    private int performSearch(int[] nums, int left, int right, int target) {
        if(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            
            if(nums[left] <= nums[mid]) {
                if( target < nums[mid] && target >= nums[left]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if( target <= nums[right] && target > nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return performSearch(nums, left, right, target);
        } else {
            return -1;
        }
    }
}