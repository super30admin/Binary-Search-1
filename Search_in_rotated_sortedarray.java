// Time complexity: O(logn)
// Space complexity: O(1)
// Did this code successfully run on leetcode: Yes


class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 0 || nums == null) return -1;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            // left half is sorted
            else if(nums[low] <= nums[mid]){
                // check if target is in the left sorted half, go left
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
                // target is in the right half
                else{
                    low = mid + 1;
                }
            }
            // right half is sorted
            else{
                // check if target is in the right sorted half, go right
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                //target is in the left half
                else {
                    high = mid - 1;
                }
            }

        }
        return -1;


    }
}
