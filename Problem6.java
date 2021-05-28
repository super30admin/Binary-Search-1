// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target) return mid; //found the index

            //Search left part of the mid
            if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low])
                    high = mid-1;
                else
                    low = mid+1;
            }

            //Search right part of the mid
            if(nums[mid] <= nums[high]){
                if(target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}

