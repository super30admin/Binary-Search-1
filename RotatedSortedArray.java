// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

public class RotatedSortedArray {
    public int search(int[] nums, int target) {

        //check nums array null or not
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2; // to overcome integer overflow

            // if mid elements will be the target it will return the mid index
            if(nums[mid] == target){
                return mid;
            }

            // if left part is sorted
            if(nums[low] <= nums[mid]){
                // if target is between low and mid point set high to (mid - 1) to move left side
                if(target >= nums[low] && target < nums[mid] ){
                    high = mid -1;
                }
                // otherwise set low to (mid + 1) to move right side
                else {
                    low = mid + 1;
                }
            }
            // if right part is sorted
            else{
                // if target is between mid and high point set low to (mid + 1) to move right side
                if(target > nums[mid] && target <= nums[high] ){
                    low = mid + 1;
                }
                // otherwise set high to (mid - 1) to move left side
                else {
                    high = mid -1;
                }
            }
        }
        // if the element is not available in array, it will return -1
        return -1;
    }
}
