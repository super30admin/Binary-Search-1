//time complexcity: O(log n)
//space complexcity: O(1)
//Did it run successfully on leetcode: YES

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid; // return the index
            }
            else if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) { //check if the element exist in sorted part
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) { //check if the element exist in unsorted part
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;        
    }
}