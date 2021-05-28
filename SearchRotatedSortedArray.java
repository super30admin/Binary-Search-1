// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high -low) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){
                //left sorted
                if(nums[low] <= target && target < nums[mid]){
                    // target is in sorted array
                    high = mid-1;
                } else
                    low = mid+1;

            } else {
                //right sorted
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                } else
                    high = mid -1;
            }
        }
        return -1;
    }
}
