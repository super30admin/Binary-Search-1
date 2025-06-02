// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            System.out.println(nums[mid]);

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target <= nums[high] && target >= nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
