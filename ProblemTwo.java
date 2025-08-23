// Did this code successfully run on Leetcode : Yes
// TC: O(1)
// SC: O(1)
// Use binary search since it is a sorted array
// Check which half is sorted and then apply binary search on that half if the target is present in it or ignore it 
class ProblemOne {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            } else {
               if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }
        }

        return -1;
    }
}