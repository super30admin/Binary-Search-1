// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            //to know which side is sorted
            if(nums[low] <= nums[mid]) {
                //left sorted
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
            else {
                //right sorted
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                else
                    high = mid;
            }
        }
        if(nums[low] == target) return low;
        return -1;

    }
}
