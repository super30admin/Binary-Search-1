// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null){
            return -1;
        }
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            //check if left part is sorted
            if(nums[low] <= nums[mid]){
                //check if the target lies in the left range
                if(target>=nums[low] && target<=nums[mid]){
                    //if so change the high and low accordingly
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            //otherwise check if right part is sorted
            else{
                //check if the target lies in the right range
                if(target <= nums[high] && target >= nums[mid+1]){
                    //if so change the high and low accordingly
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