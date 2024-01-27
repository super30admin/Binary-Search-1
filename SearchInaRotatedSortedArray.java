class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                //left Sorted
                //Check if target is in the range
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }else 
                {
                    left = mid + 1;
                }
            }else {
                //right sorted
                if(nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}