/*
Time complexity - logn
Space complexity- O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/

public class SearchLC33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high) {
            int mid =low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
                //left is sorted
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid -1;
                } else{
                    low = mid +1;
                }
            } else {
                //right sorted
                if(nums[high] >= target && nums[mid] < target) {
                    low = mid +1;
                } else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
