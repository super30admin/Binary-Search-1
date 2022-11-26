// Time Complexity : O(logn)
// Space Complexity : O(1)
/*
 * The array will contain one of the side sorted when divided into two parts.
 * We will run the binary search only on the sorted side if the target is present.
 * else we will go to the other side and again divide it into two to find the sorted side.
 */

public class Rotated_array {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;
        
        while(high >= low){
            int mid = low + (high-low)/2;
            if (nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(nums[mid] > target && nums[low] <= target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[high] >= nums[mid]){
                if(nums[mid] < target && nums[high] >= target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}