// Time Complexity :
//O(LogN)

//// Space Complexity :
//O(1) Not sure, please let me know if its correct
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]==target){
                return mid;
            }

            //Left Sorted
            if (nums[low]<=nums[mid]){
                //Check if target falls in this section
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid+1;
                }
            }
            //Right sorted
            else{
                if (nums[mid]<=target && target<=nums[high]){
                    low =mid+1;
                }
                else{
                    high = mid-1;
                }

            }
        }
        return -1;
    }
}