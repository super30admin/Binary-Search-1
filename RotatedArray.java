// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was not able to think optimum approach straight away

class RotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length;
        int low = 0, high = nums.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target)
                return mid;

                //left side sorted
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            //right side sorted
            else{
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}